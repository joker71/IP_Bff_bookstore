package com.example.demo3.controller;

import com.example.demo3.config.BaseResponse;
import com.example.demo3.entity.Author;
import com.example.demo3.exception.ResourceExeptionNotFound;
import com.example.demo3.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/get")
    public List<Author> showAll(){return this.authorService.getAll();}

    @GetMapping("/get/{id}")
    public Optional<Author> getAuthor(@PathVariable Integer id)
    {
        Optional<Author> result= this.authorService.getById(id);
        return result;
    }
    @PostMapping("/post")
    public HttpStatus postAuthor(@RequestBody Author author)
    {
        this.authorService.saveAuthor(author);
        return HttpStatus.CREATED;         
    }
    @PutMapping("/put")
    public BaseResponse<Author> putAuthor( @RequestBody Author author) throws ResourceExeptionNotFound
    {
        Integer id= author.getAuthor_id();
        Optional<Author> data= this.authorService.getById(id);
        if(!data.isPresent())
        {
            return new BaseResponse<Author>(false, Arrays.asList("Tac gia không tồn tại"), 400, null);
        }
        else
        {
            this.authorService.saveAuthor(author);
            return new BaseResponse<Author>(true, Arrays.asList("Cap nhat thong tin thanh cong"), 200, null);
        }
    }
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteAuthor(@PathVariable int id) throws ResourceExeptionNotFound
    {
        return this.authorService.deleteAuthor(id);
    }


}
