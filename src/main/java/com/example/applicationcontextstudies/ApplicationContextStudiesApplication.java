package com.example.applicationcontextstudies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@SpringBootApplication
public class ApplicationContextStudiesApplication {

    public static void main(String[] args) {
        //SpringApplication.run(ApplicationContextStudiesApplication.class, args);
        var context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        /* output should be like following.
        internalCommonAnnotationProcessor, org.springframework.context.annotation.internalPersistenceAnnotationProcessor, org.springframework.context.event.internalEventListenerProcessor, org.springframework.context.event.internalEventListenerFactory, config, personMary]
         */
    }

}

@AllArgsConstructor
@Getter
@Setter
class Person{
    private String name;
}

@Configuration
class Config{

    @Bean
    public Person personMary(){
        return new Person("mary");
    }
}
