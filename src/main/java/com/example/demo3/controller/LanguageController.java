package com.example.demo3.controller;

import com.example.demo3.config.BaseResponse;
import com.example.demo3.entity.Language;
import com.example.demo3.exception.ResourceExeptionNotFound;
import com.example.demo3.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping("/get")
    public List<Language> showAll(){return this.languageService.getAll();}

    @GetMapping("/get/{id}")
    public Optional<Language> getLanguage(@PathVariable Integer id)
    {
        Optional<Language> result= this.languageService.getById(id);
        return result;
    }
    @PostMapping("/post")
    public HttpStatus postLanguage(@RequestBody Language Language)
    { 
        this.languageService.saveLanguage(Language);
        return HttpStatus.CREATED;         
    }
    @PutMapping("/put")
    public BaseResponse<Language> putLanguage(@RequestBody Language Language) throws ResourceExeptionNotFound
    {
        Integer id= Language.getLanguage_id();
        Optional<Language> data= this.languageService.getById(id);
        if(!data.isPresent())
        {
            return new BaseResponse<Language>(false, Arrays.asList("Tac gia không tồn tại"), 400, null);
        }
        else
        {
            this.languageService.saveLanguage(Language);
            return new BaseResponse<Language>(true, Arrays.asList("Cap nhat thong tin thanh cong"), 200, null);
        }
    }
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteLanguage(@PathVariable int id) throws ResourceExeptionNotFound
    {
        return this.languageService.deleteLanguage(id);
    }
}
