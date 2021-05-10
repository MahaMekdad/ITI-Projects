// package org.example.config;

// import javax.servlet.ServletContext;
// import javax.servlet.ServletException;
// import javax.servlet.ServletRegistration;

// import org.springframework.web.WebApplicationInitializer;
// import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
// import org.springframework.web.servlet.DispatcherServlet;

// public class ApplicationInitializer implements WebApplicationInitializer{

//     @Override
//     public void onStartup(ServletContext container) throws ServletException {
//         // AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
//         // appContext.register(ApplicationConfiguration.class);
//         // appContext.setServletContext(container);
//         // ServletRegistration.Dynamic servlet = container.addServlet("app", new DispatcherServlet(appContext));
//         // servlet.setLoadOnStartup(1);
//         // servlet.addMapping("/");
//         AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
//         applicationContext.register(ApplicationConfiguration.class);
//         DispatcherServlet servlet = new DispatcherServlet(applicationContext);
//         ServletRegistration.Dynamic registration = container.addServlet("app", servlet);
//         registration.setLoadOnStartup(1);
//         registration.addMapping("/");
//     }
    
// }
