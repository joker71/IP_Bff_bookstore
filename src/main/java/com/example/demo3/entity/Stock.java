package com.example.demo3.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "store_history")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "store_id")
    private Integer store_id;

    @Column(name = "book_id")
    private Integer book_id;

    @Column(name = "number_item")
    private Integer number_item;

    @Column(name = "status_date")
    private Date status_date;

    @Column(name = "input_price")
    private Integer input_price;

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Stock() {
    }

    public Stock(Integer store_id, Integer book_id, Integer number_item, Date status_date, Integer input_price) {
        this.store_id= store_id;
        this.book_id = book_id;
        this.number_item = number_item;
        this.status_date = status_date;
        this.input_price = input_price;
    }

    public Date getStatus_date() {
        return status_date;
    }

    public void setStatus_date(Date status_date) {
        this.status_date = status_date;
    }

    public Integer getInput_price() {
        return input_price;
    }

    public void setInput_price(Integer input_price) {
        this.input_price = input_price;
    }

    public Integer getNumber_item() {
        return number_item;
    }

    public void setNumber_item(Integer number_item) {
        this.number_item = number_item;
    }

    public Integer getStore_id() {
        return store_id;
    }

    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }
}
