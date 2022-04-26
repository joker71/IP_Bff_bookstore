package com.example.demo3.repository;

import com.example.demo3.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
