package org.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class UserController {

    @Autowired
    private UserService userService;

    // @RequestMapping(method = RequestMethod.GET)
    // public String displayAllUsers(Model data){
    //     System.out.println("Innside the register");
    //     List<User> users = userService.getUsers();
    //     data.addAttribute("users", users);
    //     return "displayUsers";
    // }

    @RequestMapping(method = RequestMethod.GET)
    public String createNewUser(Model model){
        model.addAttribute(new User());
        return "formView";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
        if(result.hasErrors()){
            System.out.println(user.getName() + " -- " + user.getAge() + " -- " + user.getEmail() + " -- " + user.getPhone() + "<--*");
            model.addAttribute(user);
            return "formView";
        }
        else{
            user.setId(userService.getSize()+1);
            userService.addUser(user);
            System.out.println(user.getName() + " -- " + user.getAge() + " -- " + user.getEmail() + " -- " + user.getPhone() + "<--*");
            return "successView";
        }
    }
    
}
