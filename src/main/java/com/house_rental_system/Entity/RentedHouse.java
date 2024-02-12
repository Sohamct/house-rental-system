package com.house_rental_system.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Rented_House")
public class RentedHouse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int house_id;
	@Column
	String house_address;
	@Column
	String house_city;
	@Column
	double house_rent;
	@Column
	String house_info;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
		      CascadeType.REFRESH })
	@JoinColumn(name = "owner_id")
	private Owner owner;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
		      CascadeType.REFRESH })
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public RentedHouse() {}
	
	public RentedHouse(int house_id, String house_address, String house_city, double rent, String house_info) {
		super();
		this.house_address = house_address;
		this.house_city =house_city;
		this.house_rent  = rent;
		this.house_info = house_info;
	}

	public int getHouse_id() {
		return house_id;
	}

	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}

	public String getHouse_address() {
		return house_address;
	}

	public void setHouse_address(String house_address) {
		this.house_address = house_address;
	}

	public String getHouse_city() {
		return house_city;
	}

	public void setHouse_city(String house_city) {
		this.house_city = house_city;
	}

	public double getHouse_rent() {
		return house_rent;
	}

	public void setHouse_rent(double house_rent) {
		this.house_rent = house_rent;
	}

	public String getHouse_info() {
		return house_info;
	}

	public void setHouse_info(String house_info) {
		this.house_info = house_info;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void setCustomerId(int id) {
		this.customer.customer_id = id;
	}
	public void setOwnerId(int id) {
		this.owner.owner_id = id;
	}
	public int getCustomerId(int id) {
		return this.customer.customer_id;
	}
	public int getOwnerId(int id) {
		return this.owner.owner_id ;
	}
}
