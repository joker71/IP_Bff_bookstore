package com.example.demo3.controller;

import com.example.demo3.entity.Order;
import com.example.demo3.entity.ShippingMethor;
import com.example.demo3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/get")
    public List<Order> getAll()
    {
        return this.orderService.getAllOrder();
    }

    @GetMapping("/shipping")
    public List<ShippingMethor> getShippingMethol()
    {
        return this.orderService.getShippingMethor();
    }

}
