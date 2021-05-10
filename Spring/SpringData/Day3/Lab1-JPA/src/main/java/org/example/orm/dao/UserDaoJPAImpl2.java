package org.example.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.example.orm.entities.UserEntity;
import org.springframework.transaction.annotation.Transactional;

public class UserDaoJPAImpl2 implements UserDaoJPA{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public long count() {
        Query query = entityManager.createQuery("select count(u) from UserEntity u");
        List result = query.getResultList();
        return (long) result.get(0);
    }

    @Override
    public long countByAgeGreaterThan(int age) {
        Query query = entityManager.createQuery("select count(u) from UserEntity u where u.age > :age")
        .setParameter("age", age);
        List result = query.getResultList();
        return (long) result.get(0);
    }

    @Transactional
    @Override
    public void insert(UserEntity user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void delete(UserEntity user) {
        UserEntity userToDelete = entityManager.find(UserEntity.class, user.getUsername());
        entityManager.remove(userToDelete);
    }
    
}
