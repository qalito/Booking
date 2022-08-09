package com.tosya.may.booking.service;


import com.tosya.may.booking.entity.Partner;
import com.tosya.may.booking.entity.Role;
import com.tosya.may.booking.entity.User;
import com.tosya.may.booking.repository.PartnerRepository;
import com.tosya.may.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PartnerRepository partnerRepository;

    public User getUser(String username) {
        return userRepository.findUserByUsername(username);
    }

    public User getAuthenticationUser() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        if (SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")) {
            return null;
        } else {
            return getUser(SecurityContextHolder.getContext().getAuthentication().getName().toString());
        }
    }


    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public void createUser(Map<String, String> userMap) {
        User user = new User();
        user.setUsername(userMap.get("username"));
        user.setPassword(passwordEncoder.encode(userMap.get("password")));
        user.setName(userMap.get("name"));
        user.setEmail(userMap.get("email"));
        user.setPhoneNumber(userMap.get("phoneNumber"));
        user.setGender(userMap.get("gender").equals("female") ? User.Gender.FEMALE : User.Gender.MALE);
        user.setDateOfBirth(LocalDate.parse(userMap.get("dateOfBirth")));
        Set<Role> role = new HashSet<>();
        role.add(roleService.getRoleByName(userMap.get("role")));
        user.setRoles(role);
        user.setRegDate(LocalDateTime.now());
        user.setAccountNonLocked(true);
        userRepository.save((User) user);
        if (userMap.get("role").equals("ROLE_USER")) {
            Partner partner = new Partner();
            partner.setName(userMap.get("name"));
            partner.setRaiting(0);
            partner.setUser(user);
            user.setPartner(partner);
            partnerRepository.save(partner);
        }
    }
}
