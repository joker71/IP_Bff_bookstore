package com.example.demo3.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book_catalogue")
public class Catalogue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="\"catalogue_id\"")
    private Integer catalogue_id;

    @Column(name = "catalogue_name")
    private String catalogue_name;

}
