package com.example.demo3.service;

import com.example.demo3.entity.Order;
import com.example.demo3.entity.Orderline;
import com.example.demo3.entity.ShippingMethor;
import com.example.demo3.repository.OrderRepository;
import com.example.demo3.repository.OrderlineRepository;
import com.example.demo3.repository.ShippingMethorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderlineRepository orderlineRepository;
    
    @Autowired
    ShippingMethorRepository shippingMethorRepository;
    public Page<Order> getAllOrder(Pageable pageable)
    {
        return  this.orderRepository.findAll(pageable);
    }

    public List<ShippingMethor> getShippingMethor()
    {
        return this.shippingMethorRepository.findAll();
    }

    public void saveOrder(Order order)
    {
        this.orderRepository.save(order);
    }
    public void saveOrderline(Orderline orderline)
    {
        this.orderlineRepository.save(orderline);
    }



}
