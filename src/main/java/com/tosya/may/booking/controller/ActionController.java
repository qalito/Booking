package com.tosya.may.booking.controller;

import com.tosya.may.booking.entity.Role;
import com.tosya.may.booking.entity.User;
import com.tosya.may.booking.repository.UserRepository;
import com.tosya.may.booking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Controller
public class ActionController {
    @Autowired
    private CityService cityService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private SecurityUserDetailsService userDetailsManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String init(ModelMap model) throws IOException {
        model.addAttribute("listCity", cityService.getAll());
        model.addAttribute("listCountry", countryService.getAll());
        return "index";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpSession session) {
        session.setAttribute(
                "error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION")
        );
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping(
            value = "/register",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {
            MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public void addUser(@RequestParam Map<String, String> body) {
        User user = new User();
        user.setUsername(body.get("username"));
        user.setPassword(passwordEncoder.encode(body.get("password")));
        user.setName(body.get("name"));
        user.setEmail(body.get("email"));
        user.setPhoneNumber(body.get("phoneNumber"));
        user.setGender(body.get("gender").equals("female")? User.Gender.FEMALE:User.Gender.MALE);
        user.setDateOfBirth(LocalDate.parse(body.get("dateOfBirth")));
        user.setRole(roleService.getRoleByName("USER"));
        user.setRegDate(LocalDateTime.now());
        user.setAccountNonLocked(true);
        userDetailsManager.createUser(user);
    }
    private String getErrorMessage(HttpServletRequest request, String key) {
        Exception exception = (Exception) request.getSession().getAttribute(key);
        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username and password!";
        }
        return error;
    }
}
