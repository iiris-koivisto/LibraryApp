package com.example.library.models;

import javax.persistence.*;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	private String name;
	private String email;
	private String address;
	private int phoneNumber;
	
	public User() {
		super();
	}
	
	public User(int id, String name, String email, String address, int phoneNumber) {
		super();
		this.user_id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public int getId() {
		return user_id;
	}
	
	public void setId(int id) {
		this.user_id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {

		return "User [id = " + user_id + ", name = " + name + ", email = " + email + ", "
				+ "address = " + address + ", phone number = " + phoneNumber + "]";

	}
}
