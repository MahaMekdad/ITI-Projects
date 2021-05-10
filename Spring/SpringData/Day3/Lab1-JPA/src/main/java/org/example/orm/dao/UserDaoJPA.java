package org.example.orm.dao;

import org.example.orm.entities.UserEntity;

public interface UserDaoJPA {
    long count();
    long countByAgeGreaterThan(int age);
    void insert(UserEntity user);
    void delete(UserEntity user);
}
