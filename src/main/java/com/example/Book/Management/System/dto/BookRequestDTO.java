package com.example.Book.Management.System.dto;

import lombok.Data;
@Data
public class BookRequestDTO {
    //for creating/updating books
    private String title;
    private String author;
    private String genre;
    private Double price;
}
