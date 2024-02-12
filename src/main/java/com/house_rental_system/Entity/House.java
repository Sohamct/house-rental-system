package com.house_rental_system.Entity;

import java.util.List;

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
@Table (name = "House")
public class House {
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
	@Column
	Boolean rent_status = false;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
		      CascadeType.REFRESH })
	@JoinColumn(name = "owner_id")
	private Owner owner;
	
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
		      CascadeType.REFRESH })
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	{
		rent_status = false;
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
	public Boolean getRent_status() {
		return rent_status;
	}
	public void setRent_status(Boolean rent_status) {
		this.rent_status = rent_status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public House() {
		super();
		// TODO Auto-generated constructor stub
 	}
	public House(String house_address, String house_city, double rent, String house_info) {
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
	public String getCity() {
		return house_city;
	}
	public void setCity(String city) {
		this.house_city =city;
	}
	public double getRent() {
		return house_rent;
	}
	public void setRent(Double rent) {
		this.house_rent = rent;
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
	public void setCustomer(Customer c) {
		this.customer = c;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public int getOwnerId() {
		return owner.owner_id;
	}
	public boolean isRent_status() {
		return rent_status;
	}
	public void setRent_status(boolean rent_status) {
		this.rent_status = rent_status;
	}
	public void setCustomerId(final int id) {
		this.customer.customer_id = id;
	}
	public int getCustomerId() {
		return customer.customer_id;
	}
}
