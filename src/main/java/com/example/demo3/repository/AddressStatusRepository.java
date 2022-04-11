package com.example.demo3.repository;

import com.example.demo3.entity.AddressStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressStatusRepository extends JpaRepository<AddressStatus, Integer> {
}
