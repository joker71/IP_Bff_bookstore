package com.example.demo3.service;

import com.example.demo3.entity.Book;
import com.example.demo3.entity.Order;
import com.example.demo3.entity.OrderHistory;
import com.example.demo3.exception.ResourceExeptionNotFound;
import com.example.demo3.repository.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderStatusService {
    @Autowired
    Status status;

    public List<OrderHistory> getAll(Order order)
    {
        return this.status.findByOrder(order);
    }
    public OrderHistory saveOrderHistory(OrderHistory oh)
    {
        return  this.status.save(oh);
    }
    public Map<String, Boolean> deleteBook(Integer id) throws ResourceExeptionNotFound
    {
        OrderHistory orderHistory= this.status.findById(id).orElseThrow(()->new ResourceExeptionNotFound("Not found this post" + id));
        this.status.delete(orderHistory);
        Map<String, Boolean> response= new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return response;
    }

}
