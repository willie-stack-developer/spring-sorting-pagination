package com.cortez.willie.springsortingpagination.controller;

import com.cortez.willie.springsortingpagination.model.Book;
import com.cortez.willie.springsortingpagination.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    Page<Book> getBooks(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> sortBy)
    {
        return bookRepository.findAll(
                PageRequest.of(page.orElse(0), 5,
                        Sort.Direction.ASC,
                        sortBy.orElse("id")));
    }
}
