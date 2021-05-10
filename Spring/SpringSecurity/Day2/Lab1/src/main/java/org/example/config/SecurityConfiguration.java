// package org.example.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.factory.PasswordEncoderFactories;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    
//     @Bean
//     public PasswordEncoder passwordEncoder(){
//         return new BCryptPasswordEncoder();
//     }
//     // @Autowired
//     // public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//     //     // PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//     //     PasswordEncoder passwordEncoder = passwordEncoder();
//     //     auth.inMemoryAuthentication().withUser("Maha").password(passwordEncoder.encode("12345")).roles("USER");
//     //     auth.inMemoryAuthentication().withUser("Salma").password(passwordEncoder.encode("12345")).roles("ADMIN");
//     // }

//     @Override
//     public void configure(AuthenticationManagerBuilder auth) throws Exception {
//         // PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//         PasswordEncoder passwordEncoder = passwordEncoder();
//         auth.inMemoryAuthentication().withUser(
//             User.withUsername("Maha").password(passwordEncoder.encode("12345")).roles("USER")
//         ).withUser(
//             User.withUsername("Salma").password(passwordEncoder.encode("12345")).roles("ADMIN")
//         );

//         // auth.inMemoryAuthentication().withUser("Maha").password(passwordEncoder.encode("12345")).roles("USER");
//         // auth.inMemoryAuthentication().withUser("Salma").password(passwordEncoder.encode("12345")).roles("ADMIN");
//     }

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.authorizeRequests()
//             .antMatchers("/admin**").access("hasRole('ADMIN')")
//             .antMatchers("/user**").access("hasRole('USER')")
//             .antMatchers("/").permitAll()
//             .and().formLogin();
//     }
// }
