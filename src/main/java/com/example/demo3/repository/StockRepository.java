package com.example.demo3.repository;

import com.example.demo3.entity.Book;
import com.example.demo3.entity.Catalogue;
import com.example.demo3.entity.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    @Query(value = "SELECT b FROM Stock b WHERE b.book_id = :book_id ")
    List<Stock> findStockByBook_id(@Param("book_id") Integer book_id);

    @Query(value = "SELECT b FROM Stock b WHERE b.status_date = :status_date ")
    List<Stock> findStockByStatus_date(@Param("status_date")Date status_date);

}
