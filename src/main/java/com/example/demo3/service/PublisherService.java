package com.example.demo3.service;

import com.example.demo3.entity.Publisher;
import com.example.demo3.exception.ResourceExeptionNotFound;
import com.example.demo3.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> getAll()
    {
        return this.publisherRepository.findAll();
    }
    public Optional<Publisher> getById(int id)
    {
        return this.publisherRepository.findById(id);
    }
    public Publisher savePublisher(Publisher publisher)
    {
        return this.publisherRepository.save(publisher);
    }
    public Map<String, Boolean> deletePublisher(Integer id) throws ResourceExeptionNotFound
    {
        Publisher publisher= publisherRepository.findById(id).orElseThrow(()->new ResourceExeptionNotFound("Not found this post" + id));
        this.publisherRepository.delete(publisher);
        Map<String, Boolean> response= new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
}
