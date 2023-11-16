package com.example.library.models;

import javax.persistence.*;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employee_id;
    private String name;
    private String username;
    private String password;
    
    public Employee() {
    	super();
    }

    public Employee(int id, String name, String username, String password) {
        super();
        this.employee_id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return employee_id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public void setId(int id) {
        this.employee_id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + employee_id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

