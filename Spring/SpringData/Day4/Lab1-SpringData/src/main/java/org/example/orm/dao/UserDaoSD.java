package org.example.orm.dao;

import java.util.List;

import org.example.orm.entities.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserDaoSD extends CrudRepository<UserEntity, String>{

    int countByAgeGreaterThan(int Age);

    @Query(value = "from UserEntity u where username=:name and age=:age")
    List<UserEntity> findByUsername(@Param(value="name") String username, @Param(value="age") int x);

    @Transactional
    @Modifying
    @Query("update UserEntity u set age =:age")
    void updateAge(@Param(value="age") int age);
    
}
