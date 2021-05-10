package org.example.jdbc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.example.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class JdbcCustomerDao implements CustomerDao {

    private JdbcTemplate jdbcTemplate;
    
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // @Override
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public int count() {
        String sql = "select count(*) from users";
        int rowCount = jdbcTemplate.queryForObject(sql, Integer.class);
        return rowCount;
    }

    @Override
    public int countByAgeGreaterThan(int age) {
        String sql = "select count(*) from users where age > ?";
        int rowCount = jdbcTemplate.queryForObject(sql, new Object[]{age}, Integer.class);
        return rowCount;
    }

    @Override
    public User findByUsername(String username) {
        String sql = "select * from users where username = ?";
        Object [] args = new Object[]{username};
        User user = jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from users";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    @Override
    public void insert(User user) {
        String sql = "insert into users (username, password, age) values (:username, :password, :age)";
        Map<String, Object> args = new HashMap<>();
        args.put("username", user.getUsername());
        args.put("password", user.getPassword());
        args.put("age", user.getAge());
        namedParameterJdbcTemplate.update(sql, args);
    }

    @Override
    public void update(User user) {
        String sql = "update users set password = ?, age = ? where username = ?";
        Object [] args = new Object[]{user.getPassword(), user.getAge(), user.getUsername()}; 
        jdbcTemplate.update(sql, args);
    }

    @Override
    public void delete(String username) {
        String sql = "delete from users where username = ?";
        Object [] args = new Object[]{username}; 
        jdbcTemplate.update(sql, args);
    }

    
}
