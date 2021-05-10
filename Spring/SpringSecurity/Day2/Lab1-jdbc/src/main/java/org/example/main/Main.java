package org.example.main;

import java.security.SecureClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.example.model.User;
// import org.example.inter.Calculator;
import org.example.service.HelloUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {
    public static void main(String [] args){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Username:");
        String username = scanner.nextLine();
        System.out.println("Enter Your Password:");
        String password = scanner.nextLine();
        scanner.close();
        // System.out.println(new BCryptPasswordEncoder().encode(password));

        String [] roles = {"ROLE_TEST1","ROLE_TEST2"};
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles.length);
        for(String role : roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        // Authentication authenticationToken = new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(username, password);


        try {
            AuthenticationManager authenticationManager = applicationContext.getBean(AuthenticationManager.class);
            Authentication authentication = authenticationManager.authenticate(authenticationToken);

            System.out.println(authentication.getAuthorities());
            

            SecurityContext securityContext = new SecurityContextImpl();
            securityContext.setAuthentication(authentication);
            SecurityContextHolder.setContext(securityContext);
            System.out.println(securityContext.getAuthentication().getAuthorities() + "<-----");

            HelloUserService helloService = applicationContext.getBean("helloService", HelloUserService.class);
            // helloService.userAccessMethod(username); 
            // helloService.allAccessMethod(username);
            // helloService.adminAccessMethod(username); 
            // helloService.managerAccessMethod(username);
            // helloService.testAccessMethod(username);
            // helloService.managerPreAuthAccessMethod(username);
            // List<String> names = helloService.getNames(username);
            // List<User> names = helloService.getNames(username);
            // System.out.println(names.get(0));
            helloService.testPoint("n");

            // Calculator calculator = applicationContext.getBean("calcBeanId", Calculator.class);
            // calculator.add(58, 2);
            
        } catch (BadCredentialsException e) {
            System.out.println("Wrong username or password, **not authenticated**");
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("role access denied, **not authorized**");

        }
        
    }
}
