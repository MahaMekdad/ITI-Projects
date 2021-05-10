package org.example.main;

import org.example.orm.dao.UserDao;
import org.example.orm.dao.UserDaoImpl2;
import org.example.orm.entities.UserEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class Main {
    public static void main(String [] args){

        try{
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

            UserDao userDaoImpl = applicationContext.getBean("userDao2", UserDao.class);

            System.out.println(userDaoImpl.count() + " <-------- 1.Count");

            System.out.println(userDaoImpl.countByAgeGreaterThan(23) + " <-------- 2.CountByAge");

            System.out.println(userDaoImpl.findByUsername("maha") + " <-------- 3.FindById");

            System.out.println(userDaoImpl.findAll() + " <-------- 4.FindAll");

            userDaoImpl.insert(new UserEntity("lol", "123", 6));
            userDaoImpl.insert(new UserEntity("lol2", "123", 6));
            userDaoImpl.update(new UserEntity("lol", "99999", 9));
            userDaoImpl.delete(new UserEntity("lol2", "123", 6));

        } finally {
            AbandonedConnectionCleanupThread.checkedShutdown();
        }
    }
}
