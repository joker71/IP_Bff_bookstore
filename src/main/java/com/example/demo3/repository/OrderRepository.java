package com.example.demo3.repository;
import com.example.demo3.entity.Custom;
import com.example.demo3.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Integer> {
    @Query(value = "SELECT u FROM Order u WHERE u.custom = :custom ")
    Page<Order> findOrdersByCustom(@Param("custom") Custom custom, Pageable pageable);
}
