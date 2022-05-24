package com.example.demo3.dto;

import com.example.demo3.entity.Orderline;
import org.springframework.data.relational.core.sql.In;

public class OderLineDTO {
    private Integer line_id;
    private Integer order;
    private BookDTO book;
    private Integer price;

    public OderLineDTO(){}
    public OderLineDTO(Orderline orderline){
        this.line_id = orderline.getLine_id();
        this.order = orderline.getOrder().getId();
        this.book = new BookDTO(orderline.getBook());
        this.price = orderline.getPrice();
    }

}
