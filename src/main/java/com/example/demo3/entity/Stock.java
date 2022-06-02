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

    @Column(name = "statusDate")
    private Date statusDate;

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

    public Stock(Integer store_id, Integer book_id, Integer number_item, Date statusDate, Integer input_price) {
        this.store_id= store_id;
        this.book_id = book_id;
        this.number_item = number_item;
        this.statusDate = statusDate;
        this.input_price = input_price;
    }

    public Date getstatusDate() {
        return statusDate;
    }

    public void setstatusDate(Date statusDate) {
        this.statusDate = statusDate;
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
