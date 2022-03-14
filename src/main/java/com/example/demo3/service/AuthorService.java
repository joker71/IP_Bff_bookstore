package com.example.demo3.service;

import com.example.demo3.entity.Author;
import com.example.demo3.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAll()
    {
        return this.authorRepository.findAll();
    }
    public Optional<Author> getAuthor(int id)
    {
        return this.authorRepository.findById(id);
    }
    public Author saveAuthor(Author author)
    {
        return this.authorRepository.save(author);
    }


}
