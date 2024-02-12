package com.house_rental_system.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "Owner")
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int owner_id;
	@Column
	String owner_name;
	@Column
	String owner_address;
	@Column
	String owner_email;
	@Column
	String owner_username;
	@Column
	String owner_password;
	@Column
	String owner_phone_no;
	

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<House> house;
    
    public Owner() {}
	
	public Owner(int owner_id, String owner_name, String owner_address, String owner_email, String owner_password, 
			String owner_username, String owner_phone_no) {
		super();
		this.owner_id = owner_id;
		this.owner_name = owner_name;
		this.owner_address = owner_address;
		this.owner_email = owner_email;
		this.owner_username = owner_username;
		this.owner_password = owner_password;
		this.owner_phone_no = owner_phone_no;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getOwner_address() {
		return owner_address;
	}
	public void setOwner_address(String owner_address) {
		this.owner_address = owner_address;
	}
	public String getOwner_email() {
		return owner_email;
	}
	public void setOwner_email(String owner_email) {
		this.owner_email = owner_email;
	}
	public String getOwner_password() {
		return owner_password;
	}
	public void setOwner_password(String owner_password) {
		this.owner_password = owner_password;
	}
	public String getOwner_phone_no() {
		return owner_phone_no;
	}

	public String getOwner_username() {
		return owner_username;
	}

	public void setOwner_username(String owner_username) {
		this.owner_username = owner_username;
	}

	public void setOwner_phone_no(String owner_phone_no) {
		this.owner_phone_no = owner_phone_no;
	}
	
}
