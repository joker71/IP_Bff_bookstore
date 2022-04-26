package com.example.demo3.repository;

import com.example.demo3.entity.Order;
import com.example.demo3.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.List;

public interface Status extends JpaRepository<OrderHistory, Integer> {
    List<OrderHistory> findByOrder(Order order);
}
