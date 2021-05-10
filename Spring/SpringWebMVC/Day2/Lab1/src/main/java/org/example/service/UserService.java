package org.example.service;

import java.util.List;

import org.example.model.User;

public interface UserService {

    List<User> getUsers();
    User getUser(int id);
    void addUser(User user);
    int getSize();
}
