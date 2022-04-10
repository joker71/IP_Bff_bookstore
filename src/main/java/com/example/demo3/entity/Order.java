package com.example.demo3.entity;



import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="cust_order")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id")
	private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "customer_id")
	Custom custom;

	@Column(name="order_date")
	Date order_date;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shipping_method_id")
	ShippingMethor shippingMethor;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "dest_address_id")
	Address address;

	public Order(Integer id, Custom custom, Date order_date, ShippingMethor shippingMethor, Address address) {
        this.id = id;
        this.custom = custom;
        this.order_date = order_date;
        this.shippingMethor = shippingMethor;
        this.address = address;
    }

    public Custom getCustom() {
		return custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public ShippingMethor getShippingMethor() {
		return shippingMethor;
	}

	public void setShippingMethor(ShippingMethor shippingMethor) {
		this.shippingMethor = shippingMethor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Order(){}
}