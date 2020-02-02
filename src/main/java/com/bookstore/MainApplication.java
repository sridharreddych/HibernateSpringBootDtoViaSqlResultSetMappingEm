package com.bookstore;

import java.util.List;
import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.bookstore.dto.AuthorDto;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            List<AuthorDto> authors = bookstoreService.fetchNameAndAge();

            System.out.println("Number of authors:" + authors.size());

            for (AuthorDto author : authors) {
                System.out.println("Author name: " + author.getName() 
                        + " | Age: " + author.getAge());
            }
        };
    }
}

/*
 * How To Fetch DTO Via SqlResultSetMapping And EntityManager

Description: Fetching more data than needed is prone to performance penalities. Using DTO allows us to extract only the needed data. In this application we rely on SqlResultSetMapping and EntityManager.

Key points:

use SqlResultSetMapping and EntityManager
for using Spring Data Projections check this item

 */
