package org.example.jdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.example.model.User;

public interface CustomerDao{
    // void setDataSource(DataSource dataSource);
    int count();
    int countByAgeGreaterThan(int age);
    User findByUsername(String username);
    List<User> findAll();
    void insert(User user);
    void update(User user);
    void delete(String username);
}
