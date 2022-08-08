package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.Partner;
import com.tosya.may.booking.entity.User;
import com.tosya.may.booking.repository.PartnerRepository;
import com.tosya.may.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PartnerRepository partnerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not present"));
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
        user.setRole(roleService.getRoleByName(userMap.get("role")));
        user.setRegDate(LocalDateTime.now());
        user.setAccountNonLocked(true);
        userRepository.save((User) user);
        if (userMap.get("role").equals("PARTNER")){
            Partner partner = new Partner();
            partner.setName(userMap.get("name"));
            partner.setRaiting(0);
            partner.setUser(user);
            user.setPartner(partner);
            partnerRepository.save(partner);
        }
    }
}