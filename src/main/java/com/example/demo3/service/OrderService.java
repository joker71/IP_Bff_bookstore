package com.example.demo3.service;

import com.example.demo3.entity.Order;
import com.example.demo3.entity.ShippingMethor;
import com.example.demo3.repository.OrderRepository;
import com.example.demo3.repository.ShippingMethorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    ShippingMethorRepository shippingMethorRepository;
    public List<Order> getAllOrder()
    {
        return  this.orderRepository.findAll();
    }

    public List<ShippingMethor> getShippingMethor()
    {
        return this.shippingMethorRepository.findAll();
    }
}
