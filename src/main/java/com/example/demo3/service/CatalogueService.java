package com.example.demo3.service;

import com.example.demo3.entity.Catalogue;
import com.example.demo3.exception.ResourceExeptionNotFound;
import com.example.demo3.repository.CatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CatalogueService {
    
    @Autowired
    private CatalogueRepository catalogueRepository;

    public List<Catalogue> getAll()
    {
        return this.catalogueRepository.findAll();
    }
    public Optional<Catalogue> getById(int id)
    {
        return this.catalogueRepository.findById(id);
    }
    public Catalogue saveCatalogue(Catalogue catalogue)
    {
        return this.catalogueRepository.save(catalogue);
    }
    public Map<String, Boolean> deleteCatalogue(Integer id) throws ResourceExeptionNotFound
    {
        Catalogue catalogue= catalogueRepository.findById(id).orElseThrow(()->new ResourceExeptionNotFound("Not found this post" + id));
        this.catalogueRepository.delete(catalogue);
        Map<String, Boolean> response= new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
}
