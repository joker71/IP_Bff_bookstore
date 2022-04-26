package com.example.demo3.controller;

import com.example.demo3.config.BaseResponse;
import com.example.demo3.entity.Author;
import com.example.demo3.entity.Custom;
import com.example.demo3.exception.ResourceExeptionNotFound;
import com.example.demo3.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CutomComtroller {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public Page<Custom> listCustomer(Pageable page){
        return this.customerService.getListCustome(page);
    }
    @GetMapping("/infor/{id}")
    public Optional<Custom> getInfor(@PathVariable int id)
    {
        return  this.customerService.getCustom(id);
    }
    @PostMapping("/create")
    public HttpStatus createCustomInfor(@RequestBody Custom custom)
    {
        this.customerService.saveCustom(custom);
        return HttpStatus.CREATED;
    }
    @PutMapping("/inforupdate")
    public BaseResponse<Custom> putAuthor(@RequestBody Custom custom) throws ResourceExeptionNotFound
    {
        Integer id= custom.getCustomer_id();
        Optional<Custom> data= this.customerService.getCustom(id);
        if(!data.isPresent())
        {
            return new BaseResponse<Custom>(false, Arrays.asList("Không tìm thấy người dùng"), 400, null);
        }
        else
        {
            this.customerService.saveCustom(custom);
            return new BaseResponse<Custom>(true, Arrays.asList("Cap nhat thong tin thanh cong"), 200, null);
        }
    }

}
