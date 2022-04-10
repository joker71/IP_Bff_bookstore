package com.example.demo3.repository;

import com.example.demo3.entity.Custom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomRepository extends JpaRepository<Custom, Integer> {
}
