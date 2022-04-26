package com.example.demo3.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name= "customer")
public class Custom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Integer customer_id;

    @Column(name= "first_name")
    private String fist_name;

    @Column(name= "last_name")
    private String last_name;

    @Column(name= "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Collection<Address> address;

    public Custom(){}
    public Custom(Integer customer_id, String last_name, String fist_name )
    {
        this.customer_id= customer_id;
        this.last_name= last_name;
        this.fist_name= fist_name;
    }
    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFist_name() {
        return fist_name;
    }

    public void setFist_name(String fist_name) {
        this.fist_name = fist_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Collection<Address> getAddress() {
        return address;
    }

    public void setAddress(Collection<Address> address) {
        this.address = address;
    }
}
