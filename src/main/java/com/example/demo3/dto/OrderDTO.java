package com.example.demo3.dto;

import com.example.demo3.entity.Address;
import com.example.demo3.entity.Order;
import com.example.demo3.entity.ShippingMethor;

import java.util.Date;
import java.util.Formatter;

public class OrderDTO {
    private Integer id;
    private Date order_date;
    private ShippingMethor shippingMethor;
    private Address address;

    public OrderDTO(Integer id, Date order_date, ShippingMethor shippingMethor, Address address)
    {
        this.id = id;
        this.order_date= order_date;
        this.address = address;
        this.shippingMethor = shippingMethor;
    }

    public Address getAddress() {
        return address;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public Integer getId() {
        return id;
    }

    public ShippingMethor getShippingMethor() {
        return shippingMethor;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public void setShippingMethor(ShippingMethor shippingMethor) {
        this.shippingMethor = shippingMethor;
    }

    public OrderDTO(){}


}
