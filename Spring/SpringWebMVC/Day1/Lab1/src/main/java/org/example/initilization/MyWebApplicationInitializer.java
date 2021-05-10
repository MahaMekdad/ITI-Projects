// package org.example.initilization;

// import javax.servlet.ServletContext;
// import javax.servlet.ServletException;
// import javax.servlet.ServletRegistration;

// import org.example.config.ApplicationConfiguration;
// import org.springframework.web.WebApplicationInitializer;
// import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
// import org.springframework.web.context.support.XmlWebApplicationContext;
// import org.springframework.web.servlet.DispatcherServlet;

// public class MyWebApplicationInitializer implements WebApplicationInitializer{

//     @Override
//     public void onStartup(ServletContext ServletContext) throws ServletException {
//         XmlWebApplicationContext applicationContext = new XmlWebApplicationContext();
//         // applicationContext.setConfigLocation("/WEB-INF/applicationContext.xml");
//         DispatcherServlet servlet = new DispatcherServlet(applicationContext);
//         ServletRegistration.Dynamic registration = ServletContext.addServlet("app", servlet);
//         registration.setLoadOnStartup(1);
//         registration.addMapping("/");
//     }

//     // @Override
//     // public void onStartup(ServletContext ServletContext) throws ServletException {
//     //     AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
//     //     applicationContext.register(ApplicationConfiguration.class);
//     //     DispatcherServlet servlet = new DispatcherServlet(applicationContext);
//     //     ServletRegistration.Dynamic registration = ServletContext.addServlet("app", servlet);
//     //     registration.setLoadOnStartup(1);
//     //     registration.addMapping("/");
//     // }
    
// }
