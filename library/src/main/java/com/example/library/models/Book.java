package com.example.library.models;
import javax.persistence.*;

import java.util.Date;


@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int book_id;
	private String name;
	private String author;
	private Date publication_date;
	private String publisher;
	private String genre;
	private boolean isLoaned;
	
	public Book(int book_id, String name, String author, Date publication_date, String publisher, String genre, boolean isLoaned) {
		super();
		this.book_id = book_id;
		this.name= name;
		this.author = author;
		this.publication_date = publication_date;
		this.publisher = publisher;
		this.genre = genre;
		this.isLoaned = isLoaned;
	}
	
	public int getId() {
		return book_id;
	}
	
	public void setId(int book_id) {
		this.book_id = book_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublication_date() {
		return publication_date;
	}

	public void setPublication_date(Date publication_date) {
		this.publication_date = publication_date;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public boolean getIsLoaned() {
		return isLoaned;
	}
	
	public void setIsLoaned(boolean isLoaned) {
		this.isLoaned = isLoaned;
	}
	
	@Override
	public String toString() {
		return "Book [book_id = " + book_id + ", name = " + name + ", author = " + author
				+ ", publication date = " + publication_date + ", publisher = " + publisher
				+ ", genre = " + genre + ", loaned = " + isLoaned + "]";
	}
	
}
