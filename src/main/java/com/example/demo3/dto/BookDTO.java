package com.example.demo3.dto;

import com.example.demo3.entity.Book;
import org.springframework.data.relational.core.sql.In;

public class BookDTO {
    private Integer book_id;
    private String titile;
    private Integer price;

    private String isbn13;

    BookDTO(){}
    BookDTO(Integer book_id, String titile, Integer price, String isbn13){
        this.book_id = book_id;
        this.titile = titile;
        this.price = price;
        this.isbn13 = isbn13;
    }
    public BookDTO toDTO(Book book){
        BookDTO dto = new BookDTO();
        dto.setBook_id(book.getBook_id());
        dto.setTitile(book.getTitle());
        dto.setIsbn13(book.getIsbn13());
        dto.setPrice(book.getPrice());
        return dto;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getTitile() {
        return titile;
    }
}
