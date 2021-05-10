package org.example.orm.dao;

import java.util.List;

import org.example.orm.entities.UserEntity;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@NoRepositoryBean
public class UserDaoImpl2 extends HibernateDaoSupport implements UserDao{

    // private TransactionTemplate transactionTemplate;

    // public void setTransactionTemplate(TransactionTemplate transactionTemplate){
    //     this.transactionTemplate = transactionTemplate;
    // }

    @Override
    public long count() {
        String queryString = "select count(u) from UserEntity u";
        List result = getHibernateTemplate().find(queryString);
        return (long) result.get(0);
    }

    @Override
    public long countByAgeGreaterThan(int age) {
        String queryString = "select count(u) from UserEntity u where u.age > :age";
        List result = getHibernateTemplate().findByNamedParam(queryString, "age", age);
        return (long) result.get(0);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return getHibernateTemplate().get(UserEntity.class, username);
    }

    @Override
    public List<UserEntity> findAll() {
        String query = "from UserEntity";
        List<UserEntity> users = (List<UserEntity>) getHibernateTemplate().find(query);
        return users;
    }

    @Transactional
    @Override
    public void insert(UserEntity user) {

        getHibernateTemplate().save(user);

        // transactionTemplate.execute((TransactionCallback<Object>) new TransactionCallback<Object>(){
        //     @Override
        //     public Object doInTransaction(TransactionStatus ts) {
        //         getHibernateTemplate().save(user);
        //         return ts;
        //     }
        // });
    }
    
    @Transactional
    @Override
    public void update(UserEntity user) {
        getHibernateTemplate().update(user);

        // transactionTemplate.execute((TransactionCallback<Object>) new TransactionCallback<Object>(){
        //     @Override
        //     public Object doInTransaction(TransactionStatus ts) {
        //         getHibernateTemplate().update(user);
        //         return ts;
        //     }
        // });
    }

    @Transactional
    @Override
    public void delete(UserEntity user) {

        getHibernateTemplate().delete(user);

        // transactionTemplate.execute((TransactionCallback<Object>) new TransactionCallback<Object>(){
        //     @Override
        //     public Object doInTransaction(TransactionStatus ts) {
        //         getHibernateTemplate().delete(user);
        //         return ts;
        //     }
        // });
    }
}
