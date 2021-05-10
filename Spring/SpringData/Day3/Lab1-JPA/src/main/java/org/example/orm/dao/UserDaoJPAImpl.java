package org.example.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.example.orm.entities.UserEntity;

public class UserDaoJPAImpl implements UserDaoJPA{

    private EntityManager entityManager;

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory){
        entityManager = entityManagerFactory.createEntityManager();
    }

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

    @Override
    public void insert(UserEntity user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(UserEntity user) {
        try {
            entityManager.getTransaction().begin();
            UserEntity userToDelete = entityManager.find(UserEntity.class, user.getUsername());
            entityManager.remove(userToDelete);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            entityManager.close();
        }
    }
}
