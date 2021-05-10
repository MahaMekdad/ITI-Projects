package org.example.main;

import org.example.orm.dao.UserDaoJPA;
import org.example.orm.entities.UserEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class Main {
    public static void main(String [] args){

        try{
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

            // UserDaoJPA userDaoImpl = applicationContext.getBean("userDaoJPA", UserDaoJPA.class);

            // System.out.println(userDaoImpl.count() + " <-------- 1.Count");

            // System.out.println(userDaoImpl.countByAgeGreaterThan(23) + " <-------- 2.CountByAge");

            // userDaoImpl.insert(new UserEntity("insertion", "123", 6));
            // userDaoImpl.insert(new UserEntity("insertionDelete", "123", 6));
            // userDaoImpl.delete(new UserEntity("insertionDelete", "123", 6));

            UserDaoJPA userDaoImpl2 = applicationContext.getBean("userDaoJPA2", UserDaoJPA.class);

            System.out.println(userDaoImpl2.count() + " <-------- 1.Count");

            System.out.println(userDaoImpl2.countByAgeGreaterThan(23) + " <-------- 2.CountByAge");

            userDaoImpl2.insert(new UserEntity("insertion", "123", 6));
            userDaoImpl2.insert(new UserEntity("insertionDelete", "123", 6));
            userDaoImpl2.delete(new UserEntity("insertionDelete", "123", 6));

        } finally {
            AbandonedConnectionCleanupThread.checkedShutdown();
        }
    }
}
