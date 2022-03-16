package com.example.demo3.service;

import com.example.demo3.entity.Language;
import com.example.demo3.exception.ResourceExeptionNotFound;
import com.example.demo3.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LanguageService {
    @Autowired
    private LanguageRepository languageRepository;

    public List<Language> getAll()
    {
        return this.languageRepository.findAll();
    }
    public Optional<Language> getById(int id)
    {
        return this.languageRepository.findById(id);
    }
    public Language saveLanguage(Language language)
    {
        return this.languageRepository.save(language);
    }
    public Map<String, Boolean> deleteLanguage(Integer id) throws ResourceExeptionNotFound
    {
        Language language= languageRepository.findById(id).orElseThrow(()->new ResourceExeptionNotFound("Not found this post" + id));
        this.languageRepository.delete(language);
        Map<String, Boolean> response= new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
}
