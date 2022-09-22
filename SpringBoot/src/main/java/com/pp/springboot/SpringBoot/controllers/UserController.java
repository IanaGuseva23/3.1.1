package com.pp.springboot.SpringBoot.controllers;

import com.pp.springboot.SpringBoot.models.User;
import com.pp.springboot.SpringBoot.services.UserService;
import com.pp.springboot.SpringBoot.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("user", userService.findAll());
        return "users/users";
    }

    @GetMapping("/new")
    public String addUser (@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping()
    public String saveUser (@ModelAttribute ("user") User user) {
        userService.save (user);
        return "redirect:/user";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String removeUser(@PathVariable ("id") long id) {
        userService.delete(id);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String editUser(Model model, @PathVariable ("id") long id) {
        model.addAttribute("user", userService.findOne(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute ("user") User user, @PathVariable("id") long id){
        userService.update(user);
        return "redirect:/user";
    }
}
