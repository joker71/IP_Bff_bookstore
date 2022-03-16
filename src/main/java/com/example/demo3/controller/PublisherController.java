package com.example.demo3.controller;

import com.example.demo3.config.BaseResponse;
import com.example.demo3.entity.Publisher;
import com.example.demo3.exception.ResourceExeptionNotFound;
import com.example.demo3.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/publisher")
public class PublisherController {
    
    @Autowired
    private PublisherService publisherService;

    @GetMapping("/get")
    public List<Publisher> showAll(){return this.publisherService.getAll();}

    @GetMapping("/get/{id}")
    public Optional<Publisher> getpublisher(@PathVariable Integer id)
    {
        Optional<Publisher> result= this.publisherService.getById(id);
        return result;
    }
    @PostMapping("/post")
    public Publisher postpublisher(@RequestBody Publisher publisher)
    {
        return this.publisherService.savePublisher(publisher);
    }
    @PutMapping("/put")
    public BaseResponse<Publisher> putpublisher(@RequestBody Publisher publisher) throws ResourceExeptionNotFound
    {
        Integer id= publisher.getPulisher_id();
        Optional<Publisher> data= this.publisherService.getById(id);
        if(!data.isPresent())
        {
            return new BaseResponse<Publisher>(false, Arrays.asList("nxb không tồn tại"), 400, null);
        }
        else
        {
            this.publisherService.savePublisher(publisher);
            return new BaseResponse<Publisher>(true, Arrays.asList("Cap nhat thong tin thanh cong"), 200, null);
        }
    }
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deletepublisher(@PathVariable int id) throws ResourceExeptionNotFound
    {
        return this.publisherService.deletePublisher(id);
    }
}
