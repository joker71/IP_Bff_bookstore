package com.example.demo3.controller;

import com.example.demo3.entity.Order;
import com.example.demo3.entity.Orderline;
import com.example.demo3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
@CrossOrigin
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
    @GetMapping("/line/{id}")
    public List<Orderline> getOrderLines(@PathVariable int id) throws Exception {
        return  this.orderService.getOrderLine(id);
    }
    @GetMapping("/detail/{id}")
    public Optional<Order> getOrderDetails(@PathVariable int id) {
        return  this.orderService.getOrderDetails(id);
    }
    @PostMapping("/post")
    public HttpStatus creatOrder(@RequestBody Order order)
    {
        this.orderService.saveOrder(order);
        return HttpStatus.CREATED;
    }

}
