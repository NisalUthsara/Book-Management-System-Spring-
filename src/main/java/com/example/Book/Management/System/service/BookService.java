package com.example.Book.Management.System.service;

import com.example.Book.Management.System.entity.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book updateBook(Long id, Book updatedBook);
    void deleteBook(Long id);
}
