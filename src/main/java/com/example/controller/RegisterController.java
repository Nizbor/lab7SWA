package com.example.controller;

import com.example.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String reg(@RequestParam String login, @RequestParam String password, @RequestParam String email){
        if (!userService.testLoginAndEmail(login, email)){
            userService.addUser(login, password, email);
            return "redirect:/welcome";
        }else{
            return "anewRegister";
        }
    }

}
