package com.bookstore.bookstore.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository userRepository) {
//        return args -> {
//            User mariam = new User(
//                    "Mariam",
//                    "mariam@book.gr",
//                    "12345"
//
//            );
//            mariam.setRole(UserRole.EMPLOYEE);
//
//            User alex = new User(
//                    "Alex",
//                    "alex@gmail.com",
//                    "54321"
//            );
//            alex.setRole(UserRole.CUSTOMER);
//
//            userRepository.saveAll(List.of(mariam,alex));
//
//        };
//    }
}
