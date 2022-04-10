package com.example.demo3.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_line")
public class Orderline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "line_id")
    Integer line_id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "oder_id")
    Order order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    Book book;

    @Column(name = "price")
    Integer price;

    public Orderline(){}
    public Orderline(Integer line_id, Order order, Book book, Integer price){
        this.book= book;
        this.line_id= line_id;
        this.order= order;
        this.line_id= line_id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setLine_id(Integer line_id) {
        this.line_id = line_id;
    }

    public Integer getLine_id() {
        return line_id;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

}
