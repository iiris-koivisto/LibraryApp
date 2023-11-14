package com.example.library.models;

import javax.persistence.*;

@Entity

public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loan_id;
	private Date start_date;
	private Date end_date;
	private Boolean isReturned;
	private int employee_id;
	private int book_id;
	private int user_id;
	private int movie_id;
	
	public Loan(int id, Date start_date, Date end_date, Boolean isReturned, int employee_id, int book_id, int user_id, int movie_id) {
		super();
		this.loan_id = id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.isReturned = isReturned;
		this.employee_id = employee_id;
		this.book_id = book_id;
		this.movie_id = movie_id;
		this.user_id = user_id;
	}
	
	public int getId() {
		return loan_id;
	}
	
	public void setId(int id) {
		this.loan_id = id;
	}
	
	public date getStartDate() {
		return start_date;
	}
	
	public void setStartDate(Date start_date) {
		this.start_date = start_date;
	}
	
	public date getEndDate() {
		return end_date;
	}
	
	public void setEndDate(Date end_date) {
		this.end_date = end_date;
	}
	
	public int getIsReturned() {
		return start_date;
	}
	
	public void setIsReturned() {
		this.start_date = start_date;
	}

    public int getMovieId() {
		return movie_id;
	}
	
	public void setMovieId(int id) {
		this.movie_id = id;
	}
	
    public int getEmployeeId() {
		return employee_id;
	}
	
	public void setEmployeeId(int id) {
		this.employee_id = id;
	}
	
    public int getUserId() {
		return user_id;
	}
	
	public void setUserId(int id) {
		this.user_id = id;
	}
	
    public int getBookId() {
		return book_id;
	}
	
	public void setBookId(int id) {
		this.book_id = id;
	}
	
    @Override
    public String toString() {
        return "Loan{" +
                "id=" + loan_id +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", isReturned='" + isReturned + '\'' +
                ", employee_id='" + employee_id + '\'' +
                ", book_id='" + book_id + '\'' +
                ", movie_id='" + movie_id + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
	
}
