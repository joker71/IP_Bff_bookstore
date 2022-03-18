package com.example.demo3.entity;

import javax.persistence.*;

@Entity
@Table(name = "\"publisher\"" )
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "\"pulisher_id\"")
    private Integer pulisher_id;

    @Column(name = "publisher_name")
    private String publisher_name;

    public Publisher(){}
    public Publisher(String publisher_name, int pulisher_id)
    {
        this.publisher_name= publisher_name;
        this.pulisher_id= pulisher_id;
    }

    public Integer getPulisher_id() {
        return pulisher_id;
    }

    public void setPulisher_id(Integer pulisher_id) {
        this.pulisher_id = pulisher_id;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }
}

