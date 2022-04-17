package com.example.demo3.service;

import com.example.demo3.entity.Custom;
import com.example.demo3.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomRepository customRepository;

    public Page<Custom> getListCustome(Pageable pageable)
    {
        return  this.customRepository.findAll(pageable);
    }
    public Optional<Custom> getCustom(int id)
    {
        return  this.customRepository.findById(id);
    }
    public void saveCustom(Custom custom){
        this.customRepository.save(custom);
    }
}
