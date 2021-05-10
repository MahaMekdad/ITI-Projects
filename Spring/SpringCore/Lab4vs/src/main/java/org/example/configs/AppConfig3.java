package org.example.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/configXml.xml")
public class AppConfig3 {
    @Value("${test}")
    private String testVal;

    @Bean
    public void PropValueRead(){
        System.out.println(this.testVal + " <--------");
    }
}
