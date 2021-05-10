package org.example.controller;

import java.util.List;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/users")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/getUsers", method = RequestMethod.GET)
    public String displayAllUsers(Model data){
        List<User> users = userService.getUsers();
        data.addAttribute("users", users);
        return "displayUsers";
    }

    @RequestMapping(value="/getUser", method = RequestMethod.GET, params = "userId")
    public String displayUser(@RequestParam("userId") int id, Model data){
        User user = userService.getUser(id);
        data.addAttribute("user", user);
        return "displayUsers";
    }

    // doesnt work?
    // @RequestMapping(value="/{userId}", method = RequestMethod.GET)
    // public String displayUser(@PathVariable("userId") int id, Model data){
    //     User user = userService.getUser(id);
    //     data.addAttribute("user", user);
    //     return "displayUsers";
    // }
    
}
