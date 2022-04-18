package ru.orlov.webcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.orlov.webcrud.model.User;
import ru.orlov.webcrud.service.UserService;

@Controller

@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "allUsers";
    }

    @RequestMapping("/add")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "userInfo";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("updateUser", userService.getByIdUser(id));
        return "editUser";
    }

    @PatchMapping("/edit")
    public String doEdit(@ModelAttribute("updateUser") User newUser) {
        userService.editUser(newUser);
        return "redirect:/users";
    }

}
