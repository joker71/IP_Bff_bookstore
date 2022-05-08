package com.example.demo3.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"book_id\"", nullable = false)
    private Integer book_id;

    @Column(name = "title")
    private String title;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "isbn13")
    private String isbn13;

    @Column(name="num_pages")
    private int num_pages;

    @Column(name="publication_date")
    private Date publication_date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "\"catalogue_id\"")
    private Catalogue catalogue;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "\"language_id\"")
    private Language language;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "\"author\"")
    private Author author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "\"publisher_id\"")
    private Publisher publisher;

    @Column(name= "\"img\"")
    private String img;

    @Column(name = "\"price\"")
    private int price;

    public Book(){}
    public Book(int book_id, String title, String isbn13,int num_pages, Date publication_date, String img,Author author ,int price, Catalogue catalogue)
    {
        this.book_id= book_id;
        this.price= price;
        this.title= title;
        this.isbn13 = isbn13;
        this.num_pages= num_pages;
        this.img= img;
        this.author= author;
        this.catalogue = catalogue;
        this.publication_date= publication_date;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public com.example.demo3.entity.Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(com.example.demo3.entity.Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public int getNum_pages() {
        return num_pages;
    }

    public void setNum_pages(int num_pages) {
        this.num_pages = num_pages;
    }

    public Date getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(Date publication_date) {
        this.publication_date = publication_date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
