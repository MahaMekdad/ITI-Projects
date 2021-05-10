package org.example.main;

import org.example.models.Car;
import org.example.models.Child;
import org.example.models.Parent;
import org.example.models.TestClass;
import org.example.services.Service1;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String [] args){
        System.out.println("-------Instantiations-------");
        // ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("inheritance.xml");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("anno.xml");
        System.out.print("");
        System.out.println("-------Methods' Prints-------");

        // this was without a class att for the childBean so it made an obj of the parent and no problem
        // Parent parent = context.getBean("parentBeanConfig", Parent.class);
        // System.out.println(parent);

        //------------------------------------
        // this was with a class att for the childBean and the parent has 1 extra prop so exception
        // Error setting property values; nested exception is org.springframework.beans.NotWritablePropertyException: 
        // Invalid property 'phone' of bean class [org.example.models.Child]: 
        // Bean property 'phone' is not writable or has an invalid setter method. 
        // Does the parameter type of the setter match the return type of the getter?
        // Child child = context.getBean("childBean", Child.class);
        // System.out.println(child);

        //------------------------------------
        // classNotFoundExcp??
        // TestClass testProps = context.getBean("testProps", TestClass.class);
        // testProps.testMethod();

        //------------------------------------
        Car car = context.getBean("carBeanId", Car.class);

        //------------------------------------
        Service1 service1 = context.getBean("service1BeanId", Service1.class);
        service1.service1Operation();

        // context.registerShutdownHook();
        context.close();
    }
}
