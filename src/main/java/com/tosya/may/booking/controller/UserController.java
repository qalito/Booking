package com.tosya.may.booking.controller;

import com.tosya.may.booking.entity.User;
import com.tosya.may.booking.service.RoleService;
import com.tosya.may.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    RoleService roleService;

    @GetMapping("/account")
    public String getUserInfo(ModelMap model) {
        model.addAttribute("user", userService.getAuthenticationUser());
        System.out.println(userService.getAuthenticationUser());
        return "account";
    }

    @GetMapping("/account/edit")
    public String getUserEdit(ModelMap model) {
        model.addAttribute("user", userService.getAuthenticationUser());
        System.out.println(userService.getAuthenticationUser());
        return "account_edit";
    }

    @PostMapping("/account/edit")
    public String editUser(@RequestParam Map<String, String> body) {
        User user = userService.getAuthenticationUser();
        user.setName(body.get("name"));
        user.setEmail(body.get("email"));
        user.setPhoneNumber(body.get("phoneNumber"));
        user.setGender(body.get("gender").equals("female")? User.Gender.FEMALE:User.Gender.MALE);
        user.setDateOfBirth(LocalDate.parse(body.get("dateOfBirth")));
        user.setRole(roleService.getRoleByName("USER"));
        user.setRegDate(LocalDateTime.now());
        user.setAccountNonLocked(true);
        userService.save(user);
        return "account";
    }
}
