package com.example.demo3.controller;

import com.example.demo3.entity.Order;
import com.example.demo3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/get")
    public Page<Order> getList(Pageable page){
        return this.orderService.getAllOrder(page);
    }
    @GetMapping("/get/{id}")
    public Page<Order> getCustomOrder(@PathVariable int id, Pageable p) throws Exception {
        return  this.orderService.customOrder(id, p);
    }
    @PostMapping("/post")
    public HttpStatus creatOrder(@RequestBody Order order)
    {
        this.orderService.saveOrder(order);
        return HttpStatus.CREATED;
    }

}
