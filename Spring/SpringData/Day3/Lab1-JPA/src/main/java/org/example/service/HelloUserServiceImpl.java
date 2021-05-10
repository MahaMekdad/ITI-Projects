package org.example.service;

import java.util.ArrayList;
import java.util.List;

import org.example.model.User;
import org.springframework.security.access.annotation.Secured;

public class HelloUserServiceImpl implements HelloUserService{

    @Secured(value = {"ROLE_USER"})
    @Override
    public void userAccessMethod(String name) {
        System.out.println("Hi " + name + ", from userAccessMethod, congrats u're authorized");
    }

    @Override
    public void adminAccessMethod(String name) {
        System.out.println("Hi " + name + ", from adminAccessMethod, congrats u're authorized");

    }

    @Override
    public void managerAccessMethod(String name) {
        System.out.println("Hi " + name + ",  from managerAccessMethod, congrats u're authorized");

    }

    @Override
    public void testAccessMethod(String name) {
        System.out.println("Hi " + name + ",  from testAccessMethod, congrats u're authorized");

    }

    @Override
    public void allAccessMethod(String name) {
        System.out.println("Hi " + name + ",  from allAccessMethod, congrats u're authorized");
        
    }

    @Override
    public void managerPreAuthAccessMethod(String name) {
        System.out.println("Hi " + name + ",  from managerPreAuthAccessMethod, congrats u're authorized");
        
    }

    @Override
    public List<User> getNames(String name) {
        List<User> names = new ArrayList<>();
        // names.add(new User("salma"));
        // names.add(new User("reem"));
        // names.add(new User("mahaa"));
        return names;
    }

    @Override
    public void testPoint(String n) {
        System.out.println("LOL");
    }

    // @Override
    // public List<String> getNames(String name) {
    //     List<String> names = new ArrayList<>();
    //     names.add("salma");
    //     names.add("reem");
    //     names.add("maha");
    //     return names;
    // }
    
}
