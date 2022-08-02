package com.tosya.may.booking.controller;

import com.tosya.may.booking.entity.User;
import com.tosya.may.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class RegistrationController {
/*
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {
        System.out.println("post");
        userForm.setRegDate(LocalDateTime.now());
        System.out.println("/*");
        if (bindingResult.hasErrors()) {
            System.out.println("5*"+bindingResult.toString());
            return "registration";
        }
        System.out.println("/");
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            System.out.println("7*");
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
        System.out.println("//");
        if (!userService.saveUser(userForm)){
            System.out.println("*7");
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }
        System.out.println("*");
        return "redirect:/";
    }*/
}

