package com.cortez.willie.springsortingpagination;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSortingPaginationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSortingPaginationApplication.class, args);
    }

    @Bean
    Faker faker(){
        return new Faker();
    }
}
