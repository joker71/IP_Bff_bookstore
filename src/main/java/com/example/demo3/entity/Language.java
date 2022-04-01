package com.example.demo3.entity;

import javax.persistence.*;

@Entity
@Table(name = "\"book_language\"")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "\"language_id\"", nullable = false)
    private Integer language_id;

    @Column(name = "\"language_code\"")
    private String language_code;

    @Column(name= "\"language_name\"")
    private String language_name;

    public Language(){}

    public Language(int language_id, String language_code, String language_name)
    {
        this.language_code= language_code;
        this.language_id= language_id;
        this.language_name= language_name;
    }

    public Integer getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(Integer language_id) {
        this.language_id = language_id;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }

    public String getLanguage_name() {
        return language_name;
    }

    public void setLanguage_name(String language_name) {
        this.language_name = language_name;
    }
}
