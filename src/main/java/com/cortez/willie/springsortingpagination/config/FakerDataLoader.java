package com.cortez.willie.springsortingpagination.config;

import com.cortez.willie.springsortingpagination.model.Book;
import com.cortez.willie.springsortingpagination.repository.BookRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class FakerDataLoader implements CommandLineRunner {

    private BookRepository bookRepository;
    private Faker faker;

    public FakerDataLoader(BookRepository bookRepository, Faker faker) {
        this.bookRepository = bookRepository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Book> books = IntStream.rangeClosed(1,100)
                .mapToObj(i -> new Book(
                        faker.book().title(),
                        faker.book().author()
                )).collect(Collectors.toList());
        bookRepository.saveAll(books);
    }
}
