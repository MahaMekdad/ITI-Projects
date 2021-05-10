package com.example.lab2;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletContextEvent;

public class AppLifeCycleEvent implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("inside the contextInitialized");
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("counter", 0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {}
}
