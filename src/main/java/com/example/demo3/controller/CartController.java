package com.example.demo3.controller;

import com.example.demo3.entity.Order;
import com.example.demo3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/get")
    public Page<Order> getList(Pageable page){
        return this.orderService.getAllOrder(page);
    }

}
