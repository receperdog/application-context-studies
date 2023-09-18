package com.example.applicationcontextstudies;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@SpringBootApplication
public class ContextTest {

    public static void main(String[] args) {
        SpringApplication.run(ContextTest.class, args);
    }
}
@Configuration
@AllArgsConstructor
class ConfigApplicationContext{
    private final ApplicationContext applicationContext;

    @Bean
    public ApplicationContext getApplicationContext(){
        return applicationContext;
    }
}
@Service
@AllArgsConstructor
class Test implements CommandLineRunner {
    private ConfigApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(Arrays.toString(context.getApplicationContext().getBeanDefinitionNames()));
    }
}
