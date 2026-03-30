package com.hieudev.ss8_validate_formlogin.controller;

import com.hieudev.ss8_validate_formlogin.entity.User;
import com.hieudev.ss8_validate_formlogin.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/add")
    public String showAddUserForm(ModelMap model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @PostMapping("/save-user")
    public String home(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "add";
        }
        boolean success = iUserService.save(user);
        if (success) {
            model.addAttribute("user", user);
            return "home";
        }

        model.addAttribute("error", "Failed to save user. Please check the input data.");
        return "add";
    }
}
