package org.example.jdbc.dao;

import java.util.List;

import org.example.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcCustomerDao2 extends JdbcDaoSupport implements CustomerDao{

    @Override
    public int count() {
        String sql = "select count(*) from users";
        int rowCount = getJdbcTemplate().queryForObject(sql, Integer.class);
        return rowCount;
    }

    @Override
    public int countByAgeGreaterThan(int age) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public User findByUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void insert(User user) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(User user) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(String username) {
        // TODO Auto-generated method stub
        
    }
    
}
