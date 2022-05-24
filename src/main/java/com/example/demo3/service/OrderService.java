package com.example.demo3.service;

import com.example.demo3.entity.*;
import com.example.demo3.exception.ResourceExeptionNotFound;
import com.example.demo3.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderlineRepository orderlineRepository;
    @Autowired
    private CustomRepository customRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Autowired
    ShippingMethorRepository shippingMethorRepository;

    public Page<Order> getAllOrder(Pageable pageable) {
        return this.orderRepository.findAll(pageable);
    }

    public List<ShippingMethor> getShippingMethor() {
        return this.shippingMethorRepository.findAll();
    }

    public void saveOrder(Order order) {
        UtilService utilService = new UtilService();
        Order savedOrder = this.orderRepository.save(order);
        OrderStatus status = this.orderStatusRepository.getById(1);
        OrderHistory newOrderHistory = new OrderHistory();
        newOrderHistory.setOrder(savedOrder);
        newOrderHistory.setStatus_date(utilService.getToDay());
        newOrderHistory.setOrderStatus(status);
        this.statusRepository.save(newOrderHistory);
    }

    public void saveOrderline(Orderline orderline) {
        this.orderlineRepository.save(orderline);
    }

    public void deleteOrderLine(Integer id) throws Exception{
        Orderline orderline = this.orderlineRepository.findById(id).orElseThrow(() -> new ResourceExeptionNotFound("Order id not found " + id));
        this.orderlineRepository.delete(orderline);
    }

    public List<Orderline> getOrderLine(Integer id) throws Exception {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceExeptionNotFound("Order is not found " + id));
        return this.orderlineRepository.findOrderlineByOrder(order);
    }

    public Page<Order> customOrder(Integer id, Pageable pageable) throws Exception {
        Custom custom = customRepository.findById(id).orElseThrow(() -> new ResourceExeptionNotFound("Acount id is not found" + id));
        return this.orderRepository.findOrdersByCustom(custom, pageable);
    }


}
