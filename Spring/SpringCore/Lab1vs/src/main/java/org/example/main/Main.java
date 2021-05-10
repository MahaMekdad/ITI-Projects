package org.example.main;

import org.example.models.TestClass;
import org.example.services.Service1;
import org.example.services.Service2;
import org.example.services.Service3;
import org.example.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String [] args){
        System.out.println("-------Instantiations-------");
        // ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml", "services.xml", "collections.xml", "autowiring.xml", "scopes.xml");
        ConfigurableApplicationContext factory = new ClassPathXmlApplicationContext("autowiring.xml", "scopes.xml");
        System.out.print("");
        System.out.println("-------Methods' Prints-------");
        // Service1 service1 = (Service1) factory.getBean("service1ID");
        // service1.operation1();

        // Service1 service1 = factory.getBean("service1Id", Service1.class);
        // service1.operation1();

        System.out.println("---------------------");

        // Service3 service3 = (Service3) factory.getBean("service4ID");
        // Service3 service3 = (Service3) factory.getBean("s4n1");
        // Service3 service3 = (Service3) factory.getBean("s4n2");
        // Service3 service3 = factory.getBean("s4n2", Service3.class);

        // service3.lol();
        System.out.println("---------------------");
        // Service3 serviceFac3 = (Service3) factory.getBean("s4FromFactory");
        // Service3 serviceFac3 = factory.getBean("s4FromFactory", Service3.class);

        // serviceFac3.lol();
        // System.out.println("^from the factory");
        // System.out.println("---------------------");

        // Service2 service2Doa1 = (Service2) factory.getBean("service2IdDao1");
        // Service2 service2Doa1 = factory.getBean("service2IdDao1", Service2.class);

        // service2Doa1.operation1();
        // System.out.println("---------------------");

        // Service2 service2Doa2 = (Service2) factory.getBean("service2IdDao2");
        // Service2 service2Doa2 = factory.getBean("service2IdDao2", Service2.class);
        // service2Doa2.operation1();
        // System.out.println("---------------------");

        // Service2 service2Doa2Inter = factory.getBean("service2IdDao2Inter", Service2.class);
        // service2Doa2Inter.operation1();
        // System.out.println("---------------------");

        // BeanFactory beanFactory = (BeanFactory) factory.getBean("factoryMethodCalling");

        // String beanFactoryReturn = factory.getBean("factoryMethodCalling", java.lang.String.class);
        // System.out.println("The return from the method 'method()': " + beanFactoryReturn);
        // System.out.println("---------------------");

        // TestClass testClass = factory.getBean("testClassId", TestClass.class);
        // testClass.testMethod();
        // System.out.println("---------------------");
        // testClass.getStList();
        // testClass.getList();
        // testClass.getAddressSet();
        // testClass.getAddressMap();
        // testClass.getAddressProp();
        // System.out.println("---------------------");

        // UserService userService = factory.getBean("userServiceId", UserService.class);
        // userService.userServiceTestMethod();
        // System.out.println("---------------------");
 
        factory.registerShutdownHook();

        // Service1 s1 = factory.getBean("s1SingletonBean", Service1.class);
        // s1.operation1();
        // System.out.println(s1 + " <------singleton");
        // Service1 s1v2 = factory.getBean("s1SingletonBean", Service1.class);
        // System.out.println(s1v2 + " <------singleton v2");
        // System.out.println("---------------------Scope");

        // Service2 s2 = factory.getBean("s2PrototypeBean", Service2.class);
        // s2.operation1();
        // System.out.println(s2 + " <------prototype");
        // Service2 s2v2 = factory.getBean("s2PrototypeBean", Service2.class);
        // System.out.println(s2v2 + " <------prototype v2");
        // System.out.println("---------------------Scope");

        // factory.registerShutdownHook();
        factory.close();
    }
}
