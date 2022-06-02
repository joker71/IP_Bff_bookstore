package com.example.demo3.controller;

import com.example.demo3.entity.Book;
import com.example.demo3.service.BookService;
import com.example.demo3.service.FirebaseImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class fileController {
    @Autowired
    private FirebaseImageService imageService;
    @Autowired
    private BookService bookService;

    @PostMapping("/profile/pic/{id}")
    public ResponseEntity create(@RequestParam(name = "file") MultipartFile file, @PathVariable int id)  {

        System.out.println(id);
        int numberId = id;


            try {

                String fileName = imageService.save(file);

                String imageUrl = imageService.getImageUrl(fileName);

                Book book = bookService.findOneBook(numberId);

                book.setImg(imageUrl);

                bookService.Save(book);
                // do whatever you want with that

            } catch (Exception e) {
                System.out.println(e.toString());
            }


        return ResponseEntity.ok().build();
    }


}
