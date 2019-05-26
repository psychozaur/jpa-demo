package com.rybickim.jpademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaDemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(JpaDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner person2(PersonRepository repository){
        return args -> {
            repository.save(new Person2("Jack", "Bauer", "324324"));
            repository.save(new Person2("Chloe", "O'Brian", "3435657"));
            repository.save(new Person2("Kim", "Bauer", "343567"));

            logger.info("Persons found with findAll():");
            logger.info("-------------------------------");
            repository.findAll().forEach(person -> logger.info(person.toString()));
            logger.info("");
        };
    }

}
