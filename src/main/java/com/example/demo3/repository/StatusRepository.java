package com.example.demo3.repository;

import com.example.demo3.entity.Order;
import com.example.demo3.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatusRepository extends JpaRepository<OrderHistory, Integer> {
    List<OrderHistory> findAllByOrder(Order order);
}
