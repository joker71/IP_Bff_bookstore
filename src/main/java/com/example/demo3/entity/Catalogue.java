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

    public Integer getCatalogue_id() {
        return catalogue_id;
    }

    public void setCatalogue_id(Integer catalogue_id) {
        this.catalogue_id = catalogue_id;
    }

    public String getCatalogue_name() {
        return catalogue_name;
    }

    public void setCatalogue_name(String catalogue_name) {
        this.catalogue_name = catalogue_name;
    }
    public Catalogue()
    {}
    public Catalogue(int catalogue_id, String catalogue_name)
    {
        this.catalogue_id= catalogue_id;
        this.catalogue_name= catalogue_name;
    }
}
