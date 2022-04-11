package com.example.demo3.entity;

import javax.persistence.*;

@Entity
@Table(name= "order_status")
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "status_id")
    private Integer status_id;

    @Column(name= "status_value")
    private String status;

    public OrderStatus(){}
    public OrderStatus(Integer status_id, String s)
    {
        this.status_id= status_id;
        this.status= s;
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
