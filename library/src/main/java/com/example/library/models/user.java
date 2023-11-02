package com.example.library.models;

import java.util.ArrayList;

public class user {
	private int id;
	private String name;
	private String email;
	private String address;
	private int phoneNumber;
	private ArrayList<loanIds>;
	
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
