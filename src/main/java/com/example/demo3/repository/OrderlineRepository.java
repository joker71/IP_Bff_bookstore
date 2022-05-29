package com.example.demo3.repository;

import com.example.demo3.entity.Order;
import com.example.demo3.entity.Orderline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderlineRepository extends JpaRepository<Orderline, Integer> {
    @Query(value =  "SELECT u FROM Orderline u WHERE u.order = :order ")
    List<Orderline> findOrderlineByOrder(@Param("order")Integer order);
}
