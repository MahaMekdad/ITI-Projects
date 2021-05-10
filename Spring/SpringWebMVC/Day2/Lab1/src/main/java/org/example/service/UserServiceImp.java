package org.example.service;

import java.util.ArrayList;
import java.util.List;

import org.example.model.User;

public class UserServiceImp implements UserService{
    
    List<User> users = new ArrayList<>();
        User u1 = new User(1, "salma", 22, "0000000", "salma@email.com");
        User u2 = new User(2, "hadeer", 22, "0000000", "hadeer@email.com");
        User u3 = new User(3, "youmna", 22, "0000000", "youmna@email.com");
        {
            users.add(u1);
            users.add(u2); 
            users.add(u3);
        }
    
    public List<User> getUsers(){
        //users.add(u1); users.add(u2); users.add(u3);
        return users;
    }

    public User getUser(int id){
        for(User u : users){
            if(u.getId() == id){
                System.out.println(u.getId() + " ---- " + id + " ---- " + (u.getId() == id));
                return u;
            }
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public int getSize() {
        return users.size();
    }
}
