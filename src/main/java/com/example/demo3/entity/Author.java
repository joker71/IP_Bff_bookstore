package com.example.demo3.entity;

import javax.persistence.*;

@Entity
@Table(name = "\"author\"")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "\"author_id\"", nullable = false)
    private Integer author_id;

    @Column(name = "\"author_name\"")
    private String author_name;

    public String getAuthor_name() {
        return author_name;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public Author(){}
    public Author(int author_id, String author_name)
    {
        this.author_name= author_name;
        this.author_id= author_id;
    }
}
