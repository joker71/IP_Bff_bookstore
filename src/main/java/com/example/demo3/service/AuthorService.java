package com.example.demo3.service;

import com.example.demo3.entity.Author;
import com.example.demo3.exception.ResourceExeptionNotFound;
import com.example.demo3.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAll()
    {
        return this.authorRepository.findAll();
    }
    public Optional<Author> getById(int id)
    {
        return this.authorRepository.findById(id);
    }
    public Author saveAuthor(Author author)
    {
        return this.authorRepository.save(author);
    }
    public Map<String, Boolean> deleteAuthor(Integer id) throws ResourceExeptionNotFound
    {
        Author author= authorRepository.findById(id).orElseThrow(()->new ResourceExeptionNotFound("Not found this post" + id));
        this.authorRepository.delete(author);
        Map<String, Boolean> response= new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
}
