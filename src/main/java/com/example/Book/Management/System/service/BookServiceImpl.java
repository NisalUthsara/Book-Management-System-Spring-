package com.example.Book.Management.System.service;

import com.example.Book.Management.System.dto.BookResponseDTO;
import com.example.Book.Management.System.entity.Book;
import com.example.Book.Management.System.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper){
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Book not found with id: " + id));
    }

    @Override
    public Book updateBook(Long id, Book updatedBook) {
        Book existingBook = getBookById(id);
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setPrice(updatedBook.getPrice());
        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookResponseDTO> searchBooksByAuthor(String author){
        return bookRepository.findByAuthorContainingIgnoreCase(author)
                .stream()
                .map(book -> modelMapper.map(book, BookResponseDTO.class))
                .toList();
    }
    @Override
    public Page<BookResponseDTO> getBooksByGenreWithPagination(String genre, Pageable pageable){
        return bookRepository.findByGenreContainingIgnoreCase(genre, pageable)
                .map(book -> modelMapper.map(book, BookResponseDTO.class));    }
    }
