package com.example.demo3.service;

import com.example.demo3.entity.Book;
import com.example.demo3.exception.ResourceExeptionNotFound;
import com.example.demo3.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll()
    {
        return this.bookRepository.findAll();
    }

    public Optional<Book> findOne(int id) {
        return this.bookRepository.findById(id);
    }

    public void Save(Book book)
    {this.bookRepository.save(book);}

    public Map<String, Boolean> deleteBook(Integer id) throws ResourceExeptionNotFound
    {
        Book book= this.bookRepository.findById(id).orElseThrow(()->new ResourceExeptionNotFound("Not found this post" + id));
        this.bookRepository.delete(book);
        Map<String, Boolean> response= new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return response;
    }

}
