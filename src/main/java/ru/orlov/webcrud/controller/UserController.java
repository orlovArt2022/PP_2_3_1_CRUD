package ru.orlov.webcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.orlov.webcrud.model.User;
import ru.orlov.webcrud.service.UserService;

@Controller

public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "allUsers";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("singleUser", userService.getByIdUser(id));
        return "singleUser";
    }

    @GetMapping ("/add")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("updateUser", userService.getByIdUser(id));
        return "editUser";
    }

    @PutMapping()
    public String doEdit(@ModelAttribute("updateUser") User newUser) {
        userService.editUser(newUser);
        return "redirect:/";
    }

}
