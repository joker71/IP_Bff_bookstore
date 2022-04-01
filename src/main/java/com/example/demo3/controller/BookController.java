package com.example.demo3.controller;

import com.example.demo3.config.BaseResponse;
import com.example.demo3.entity.Author;
import com.example.demo3.entity.Book;
import com.example.demo3.exception.ResourceExeptionNotFound;
import com.example.demo3.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/get")
    public List<Book> getAll()
    {
        return  this.bookService.getAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Book> getById(@PathVariable Integer id)
    {
        return this.bookService.findOne(id);
    }

    @PostMapping("/post")
    public HttpStatus postBook(@RequestBody Book book)
    {
        this.bookService.Save(book);
        return HttpStatus.CREATED;
    }

    @PutMapping("/put")
    public BaseResponse<Book> putBook(@RequestBody Book book) throws ResourceExeptionNotFound
    {
        Integer id= book.getBook_id();
        Book book1= this.bookService.findOne(id).orElseThrow(()-> new ResourceExeptionNotFound("Can find this book "+ id));
        this.bookService.Save(book);
        return new BaseResponse<Book>(true, Arrays.asList("Cap nhat thong tin thanh cong"), 200, null);
    }
    
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteAuthor(@PathVariable int id) throws ResourceExeptionNotFound
    {
        return this.bookService.deleteBook(id);
    }


}
