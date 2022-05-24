package com.example.demo3.dto;

import com.example.demo3.entity.Book;

public class BookDTO {
    private Integer book_id;
    private String titile;
    private Integer price;

    private String isbn13;

    BookDTO(){}
    BookDTO(Book book){
        this.book_id = book.getBook_id();
        this.titile = book.getTitle();
        this.price = book.getPrice();
        this.isbn13 = book.getIsbn13();
    }
}
