package com.example.Book.Management.System.controller.v2;

import com.example.Book.Management.System.dto.BookRequestDTO;
import com.example.Book.Management.System.dto.BookResponseDTO;
import com.example.Book.Management.System.entity.Book;
import com.example.Book.Management.System.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin (origins = "http://localhost:3000")
@RestController("bookControllerV2")
@RequestMapping("/api/v2/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private ModelMapper modelMapper;

    //Create a new book
    @PostMapping("/createBook")
    public ResponseEntity<BookResponseDTO> createBook(@RequestBody BookRequestDTO bookRequestDTO){
        Book createdBook = bookService.saveBook(modelMapper.map(bookRequestDTO, Book.class));
        return ResponseEntity.ok(modelMapper.map(createdBook, BookResponseDTO.class));
    }

    //get all books
    @GetMapping("/getAllBooks")
    public ResponseEntity<List<BookResponseDTO>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        List<BookResponseDTO> responseDTOs = books.stream()
                .map(book -> modelMapper.map(book, BookResponseDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOs);
    }

    //Get a book by ID
    @GetMapping("/getBook/{id}")
    public ResponseEntity<BookResponseDTO> getBooksById(@PathVariable Long id){
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(modelMapper.map(book, BookResponseDTO.class));
    }

    //Update a book
    @PutMapping("/updateBook/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable Long id, @RequestBody BookRequestDTO bookRequestDTO){
        Book updatedBook = bookService.updateBook(id, modelMapper.map(bookRequestDTO, Book.class));
        return ResponseEntity.ok(modelMapper.map(updatedBook, BookResponseDTO.class));
    }

    //Delete a book
    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully!");
    }

    @GetMapping("/search")
    public List<BookResponseDTO> searchBooks(@RequestParam String author){
        return bookService.searchBooksByAuthor(author);
    }

    @GetMapping("/getBooksByGenre")
    public Page<BookResponseDTO> getBooksByGenre(@RequestParam String genre, Pageable pageable){
        return bookService.getBooksByGenreWithPagination(genre, pageable);
    }
}
