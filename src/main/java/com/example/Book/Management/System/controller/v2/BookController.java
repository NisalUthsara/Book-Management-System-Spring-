package com.example.Book.Management.System.controller.v2;

import com.example.Book.Management.System.dto.BookRequestDTO;
import com.example.Book.Management.System.dto.BookResponseDTO;
import com.example.Book.Management.System.entity.Book;
import com.example.Book.Management.System.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController("bookControllerV2")
@RequestMapping("/api/v2/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private ModelMapper modelMapper;

    //Create a new book
    @PostMapping
    public ResponseEntity<BookResponseDTO> createBook(@RequestBody BookRequestDTO bookRequestDTO){
        Book createdBook = bookService.saveBook(modelMapper.map(bookRequestDTO, Book.class));
        return ResponseEntity.ok(modelMapper.map(createdBook, BookResponseDTO.class));
    }

    //get all books
    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        List<BookResponseDTO> responseDTOs = books.stream()
                .map(book -> modelMapper.map(book, BookResponseDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOs);
    }

    //Get a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBooksById(@PathVariable Long id){
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(modelMapper.map(book, BookResponseDTO.class));
    }

    //Update a book
    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable Long id, @RequestBody BookRequestDTO bookRequestDTO){
        Book updatedBook = bookService.updateBook(id, modelMapper.map(bookRequestDTO, Book.class));
        return ResponseEntity.ok(modelMapper.map(updatedBook, BookResponseDTO.class));
    }

    //Delete a book
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully!");
    }
}
