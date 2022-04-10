package com.example.demo3.service;

import com.example.demo3.entity.Order;
import com.example.demo3.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrder()
    {
        return  this.orderRepository.findAll();
    }
}
