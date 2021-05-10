package org.example.main;

import org.example.orm.dao.UserDaoJPA;
import org.example.orm.dao.UserDaoSD;
import org.example.orm.entities.UserEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class Main {
    public static void main(String [] args){

        try{
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

            UserDaoSD userDaoImpl2 = applicationContext.getBean("userDaoSD", UserDaoSD.class);

            System.out.println(userDaoImpl2.count() + " <-------- 1.Count");

            System.out.println(userDaoImpl2.countByAgeGreaterThan(23) + " <-------- 2.CountByAge");

            userDaoImpl2.save(new UserEntity("data", "123", 6));
            userDaoImpl2.save(new UserEntity("data2WithAge6", "123", 6));
            userDaoImpl2.delete(new UserEntity("data", "123", 6));

            Iterable iterable = userDaoImpl2.findAll();
            Iterator iterator = iterable.iterator();
            while(iterator.hasNext()){
                UserEntity u = (UserEntity) iterator.next();
                System.out.println(u);
            }

            System.out.println(userDaoImpl2.findByUsername("maha", 22));
            userDaoImpl2.updateAge(100);          

        } finally {
            AbandonedConnectionCleanupThread.checkedShutdown();
        }
    }
}
