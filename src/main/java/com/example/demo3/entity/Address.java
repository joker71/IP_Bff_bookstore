package com.example.demo3.entity;

import javax.persistence.*;
@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "address_id")
    private Integer address_id;

    @Column(name= "street_number")
    private String streetNumber;

    @Column(name= "street_name")
    private String streetName;

    @Column(name= "city")
    private String city;

    public Address(){}
    public Address(Integer address_id, String streetName, String streetNumber, String city)
    {
        this.address_id= address_id;
        this.city= city;
        this.streetName= streetName;
        this.streetNumber= streetNumber;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public String getCity() {
        return city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
