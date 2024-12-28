package com.example.Book.Management.System.controller.v2;

import com.example.Book.Management.System.dto.BookRequestDTO;
import com.example.Book.Management.System.dto.BookResponseDTO;
import com.example.Book.Management.System.entity.Book;
import com.example.Book.Management.System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("bookControllerV2")
@RequestMapping("/api/v2/books")
public class BookController {
//    @Autowired
//    private BookService bookService;

    //create a new book
//    @PostMapping
//    public ResponseEntity<BookResponseDTO> createBook(@RequestBody BookRequestDTO bookRequestDTO){
//        bookService.saveBook()
//    }
}
