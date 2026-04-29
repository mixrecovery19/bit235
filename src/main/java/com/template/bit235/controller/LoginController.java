package com.template.bit235.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.template.bit235.service.PeopleService;

@Controller
public class LoginController {

    @Autowired
    private PeopleService peopleService;

    // 🔹 Show login page
    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("sven", "Welcome to the Melbourne Polytechnic login page!");
        return "login";
    }

    // 🔹 Handle form submission
    @PostMapping("/submituser")
    public String submitUser(String user, String pass, Model model) {

        // USE the service (clean + correct)
        if (peopleService.validateUser(user, pass)) {
            model.addAttribute("username", user);
            return "results";
        } else {
            model.addAttribute("error", "Invalid username or password. Please try again.");
            return "login"; // 🔴 IMPORTANT: go back to login
        }
    }
}