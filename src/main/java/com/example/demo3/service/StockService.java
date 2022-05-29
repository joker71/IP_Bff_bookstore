package com.example.demo3.service;

import com.example.demo3.entity.Stock;
import com.example.demo3.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockRepository repository;

    public Page<Stock> getAll(Pageable pageable){
        return this.repository.findAll(pageable);
    }
    public Stock save(Stock stock){
        return this.repository.save(stock);
    }
    public List<Stock> getByProduct(Integer bookId){
        return this.repository.findStockByBook_id(bookId);
    }
    public List<Stock> getByDate(Date date){
        return this.repository.findStockByStatus_date(date);
    }
}
