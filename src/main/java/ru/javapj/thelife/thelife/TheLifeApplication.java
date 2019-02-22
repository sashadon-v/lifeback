package ru.javapj.thelife.thelife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author alex
 */
@SpringBootApplication
@EnableAutoConfiguration
public class TheLifeApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(TheLifeApplication.class, args);
    }
}
