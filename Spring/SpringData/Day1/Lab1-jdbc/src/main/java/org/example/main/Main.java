package org.example.main;

import org.example.jdbc.dao.JdbcCustomerDao;
import org.example.jdbc.dao.JdbcCustomerDao2;
import org.example.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class Main {
    public static void main(String [] args){

        try{
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

            JdbcCustomerDao jdbcCustomerDao = applicationContext.getBean("customerDao", JdbcCustomerDao.class);

            System.out.println(jdbcCustomerDao.count() + " <-------- 1.Count");

            System.out.println(jdbcCustomerDao.countByAgeGreaterThan(23) + " <-------- 2.CountByAge");

            System.out.println(jdbcCustomerDao.findByUsername("maha") + " <-------- 3.FindById");

            System.out.println(jdbcCustomerDao.findAll() + " <-------- 4.FindAll");

            jdbcCustomerDao.insert(new User("lol", "12345", 9));
            jdbcCustomerDao.insert(new User("lol2", "12345", 9));
            jdbcCustomerDao.update(new User("lol", "99999", 9));
            jdbcCustomerDao.delete("lol2");

            JdbcCustomerDao2 jdbcCustomerDao2 = applicationContext.getBean("customerDao2", JdbcCustomerDao2.class);
            System.out.println(jdbcCustomerDao2.count() + "<---------");

        } finally {
            AbandonedConnectionCleanupThread.checkedShutdown();
        }
    }
}
