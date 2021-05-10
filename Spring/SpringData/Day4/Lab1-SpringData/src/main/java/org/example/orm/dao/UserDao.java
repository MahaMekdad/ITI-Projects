package org.example.orm.dao;

import java.util.List;

import org.example.orm.entities.UserEntity;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserDao{
    // void setDataSource(DataSource dataSource);
    long count();
    long countByAgeGreaterThan(int age);
    UserEntity findByUsername(String username);
    List<UserEntity> findAll();
    void insert(UserEntity user);
    void update(UserEntity user);
    void delete(UserEntity user);
}
