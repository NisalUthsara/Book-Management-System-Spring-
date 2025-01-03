package com.example.Book.Management.System.service;

import com.example.Book.Management.System.dto.BookResponseDTO;
import com.example.Book.Management.System.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book updateBook(Long id, Book updatedBook);
    void deleteBook(Long id);

    //methods for search and pagination
    List<BookResponseDTO> searchBooksByAuthor(String author);
    Page<BookResponseDTO> getBooksByGenreWithPagination(String genre, Pageable pageable);
}
