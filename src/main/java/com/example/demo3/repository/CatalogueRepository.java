package com.example.demo3.repository;

import com.example.demo3.entity.Catalogue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogueRepository extends JpaRepository<Catalogue, Integer> {
}
