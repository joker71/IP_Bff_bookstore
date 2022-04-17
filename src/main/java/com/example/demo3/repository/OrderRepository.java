package com.example.demo3.repository;
import com.example.demo3.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface OrderRepository  extends PagingAndSortingRepository<Order, Integer> {

}
