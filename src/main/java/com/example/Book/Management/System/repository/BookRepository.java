package com.example.Book.Management.System.repository;

import com.example.Book.Management.System.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    // JpaRepository provides built-in CRUD methods.
    // methods for search feature
    List<Book> findByAuthorContainingIgnoreCase(String author);
    List<Book> findByGenreContainingIgnoreCase(String genre);
    List<Book> findByTitleContainingIgnoreCase(String title);

    // Pagination and Sorting
    Page<Book> findByGenreContainingIgnoreCase(String genre, Pageable pageable);
    Page<Book> findByAuthorContainingIgnoreCase(String author, Pageable pageable);
}
