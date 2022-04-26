package com.example.demo3.controller;

import com.example.demo3.config.BaseResponse;
import com.example.demo3.entity.Catalogue;
import com.example.demo3.exception.ResourceExeptionNotFound;
import com.example.demo3.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/catalogue")
@CrossOrigin(origins = "http://localhost:4200")
public class CatalogueController {
    @Autowired
    private CatalogueService catalogueService;

    @GetMapping("/get")
    public List<Catalogue> showAll() {
        return  this.catalogueService.getAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Catalogue> showAll(@PathVariable Integer id){
        return  this.catalogueService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> delete(@PathVariable Integer id) throws ResourceExeptionNotFound
    {
       return this.catalogueService.deleteCatalogue(id);
    }
    @PostMapping("/post")
    public HttpStatus postCatalog(@RequestBody Catalogue catalogue){
        this.catalogueService.saveCatalogue(catalogue);
        return HttpStatus.CREATED;          
    }
    @PutMapping("/put")
    public BaseResponse<Catalogue> putAuthor(@RequestBody Catalogue catalogue) throws ResourceExeptionNotFound
    {
        Integer id= catalogue.getCatalogue_id();
        Optional<Catalogue> data= this.catalogueService.getById(id);
        if(!data.isPresent())
        {
            return new BaseResponse<Catalogue>(false, Arrays.asList("Tac gia không tồn tại"), 400, null);
        }
        else
        {
            this.catalogueService.saveCatalogue(catalogue);
            return new BaseResponse<Catalogue>(true, Arrays.asList("Cap nhat thong tin thanh cong"), 200, null);
        }
    }


}
