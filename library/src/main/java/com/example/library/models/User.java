package com.example.library.models;

public class User {
	private int id;
	private String name;
	private String email;
	private String address;
	private int phoneNumber;
	
	public User() {
		super();
	}
	
	public User(int id, String name, String email, String address, int phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
}
