package com.example.Book.Management.System.controller.v1;

import com.example.Book.Management.System.entity.Book;
import com.example.Book.Management.System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,@RequestBody Book updateBook){
        return bookService.updateBook(id, updateBook);
    }
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return "Book with ID "+id+" has been deleted successfully.";
    }
}
