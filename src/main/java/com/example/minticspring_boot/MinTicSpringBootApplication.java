package com.example.minticspring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class MinTicSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinTicSpringBootApplication.class, args);
    }

}
