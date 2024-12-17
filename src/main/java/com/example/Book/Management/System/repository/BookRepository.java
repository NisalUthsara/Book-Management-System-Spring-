package com.example.Book.Management.System.repository;

import com.example.Book.Management.System.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // JpaRepository provides built-in CRUD methods.
}
