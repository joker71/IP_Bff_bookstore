package com.example.demo3.repository;

import com.example.demo3.entity.ShippingMethor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingMethorRepository extends JpaRepository<ShippingMethor, Integer> {
}
