package com.example.demo3.service;

import com.example.demo3.entity.Book;
import com.example.demo3.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll()
    {
        return this.bookRepository.findAll();
    }
}
