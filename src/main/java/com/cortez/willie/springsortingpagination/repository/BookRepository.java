package com.cortez.willie.springsortingpagination.repository;

import com.cortez.willie.springsortingpagination.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}