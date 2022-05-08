package com.example.demo3.entity;



import org.springframework.data.relational.core.sql.In;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="cust_order")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id")
	private Integer id;

    @ManyToOne
	@JoinColumn(name= "customer_id")
	private Custom custom;

	@Column(name="order_date")
	private Date order_date;

	@Column(name = "shipping_method_id")
	private Integer shipping_method_id;

	@JoinColumn(name= "dest_address_id")
	private Integer dest_address_id;

	public Order(Integer id, Custom custom, Date order_date, Integer shippingMethor, Integer address) {
        this.id = id;
        this.custom = custom;
        this.order_date = order_date;
		this.dest_address_id = address;
		this.shipping_method_id = shippingMethor;

    }

	public Custom getCustom() {
		return custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}


	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Integer getDest_address_id() {
		return dest_address_id;
	}

	public void setDest_address_id(Integer dest_address_id) {
		this.dest_address_id = dest_address_id;
	}

	public Integer getShipping_method_id() {
		return shipping_method_id;
	}

	public void setShipping_method_id(Integer shipping_method_id) {
		this.shipping_method_id = shipping_method_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Order(){}
}