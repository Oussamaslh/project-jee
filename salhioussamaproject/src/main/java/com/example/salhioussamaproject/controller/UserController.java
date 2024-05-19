package com.example.salhioussamaproject.controller;

import com.example.salhioussamaproject.entities.User;
import com.example.salhioussamaproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model) {
        User foundUser = userService.authenticate(user.getEmail(), user.getPassword());
        if (foundUser != null) {
            model.addAttribute("user", foundUser);
            return "home";
        } else {
            model.addAttribute("error", true);
            return "login";
        }
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("user") User user) {
        userService.registerUser(user);
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String showHomePage(Model model) {
        // Add any necessary model attributes
        return "home";
    }


}
