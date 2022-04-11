package com.example.demo3.entity;

import javax.persistence.*;

@Entity
@Table(name = "address_status")
public class AddressStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="status_id")
    private Integer status_id;

    @Column(name="address_status")
    private String address_status;

    public AddressStatus(){}
    public AddressStatus(int status_id, String address_status){
        this.address_status= address_status;
        this.status_id= status_id;
    }
    public Integer getStatus_id() {
        return status_id;
    }

    public void setAddress_status(String address_status) {
        this.address_status = address_status;
    }

    public String getAddress_status() {
        return address_status;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }
}
