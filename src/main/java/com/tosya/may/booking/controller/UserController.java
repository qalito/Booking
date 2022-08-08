package com.tosya.may.booking.controller;

import com.tosya.may.booking.entity.Image;
import com.tosya.may.booking.entity.User;
import com.tosya.may.booking.repository.ImageRepository;
import com.tosya.may.booking.service.RoleService;
import com.tosya.may.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

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
    public String editUser(ModelMap model, @RequestParam Map<String, String> body) {
        User user = setUser(userService.getAuthenticationUser(), body);
        userService.save(user);
        model.addAttribute("user", userService.getAuthenticationUser());
        return "redirect:/account";
    }

    @PostMapping("/user/{username}/edit")
    public String editUserAdmin(ModelMap model, @RequestParam Map<String, String> body) {
        User user = setUser(userService.getUser(body.get("username")), body);
        userService.save(user);
        model.addAttribute("user", user);
        return "redirect:/account";
    }

    private User setUser(User user, Map<String, String> body) {
        user.setName(body.get("name"));
        user.setEmail(body.get("email"));
        user.setPhoneNumber(body.get("phoneNumber"));
        user.setGender(body.get("gender").equals("female") ? User.Gender.FEMALE : User.Gender.MALE);
        user.setDateOfBirth(LocalDate.parse(body.get("dateOfBirth")));
        user.setRole(roleService.getRoleByName(body.get("role")));
        user.setRegDate(LocalDateTime.now());
        user.setAccountNonLocked(true);
        return user;
    }

    @GetMapping("/user/{username}")
    public String getUserInfoByUsername(ModelMap model, @PathVariable("username") String username) {
        model.addAttribute("user", userService.getUser(username));
        System.out.println(userService.getAuthenticationUser());
        return "account";
    }
}
