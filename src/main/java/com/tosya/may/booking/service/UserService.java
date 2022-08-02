package com.tosya.may.booking.service;

import com.tosya.may.booking.entity.Role;
import com.tosya.may.booking.entity.User;
import com.tosya.may.booking.repository.RoleRepository;
import com.tosya.may.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService  {
}
