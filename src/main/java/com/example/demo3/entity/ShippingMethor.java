package com.example.demo3.entity;

import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;
@Entity
@Table(name = "shipping_method")
public class ShippingMethor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "method_id")
    Integer method_id;

    @Column(name= "method_name")
    String method_name;

    @Column(name = "cost")
    Integer cost;

    public Integer getCost() {
        return cost;
    }
    public ShippingMethor(){}
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getMethod_id() {
        return method_id;
    }

    public void setMethod_id(Integer method_id) {
        this.method_id = method_id;
    }

    public String getMethod_name() {
        return method_name;
    }

    public void setMethod_name(String method_name) {
        this.method_name = method_name;
    }
}
