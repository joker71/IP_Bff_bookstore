package com.example.demo3.repository;
import com.example.demo3.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.persistence.Id;


public interface OrderRepository  extends PagingAndSortingRepository<Order, Integer> {
    Page<Order> getOrderByCustom_Customer_id(Integer customer_id);
}
