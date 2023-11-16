package com.example.library.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int book_id;
	private String name;
	private String author;
	private int publication_date;
	private String publisher;
	private String genre;
	private boolean isLoaned;
	
	public Book(int id, String name, String author, String publisher, String genre, boolean isLoaned) {
		super();
		this.book_id = id;
		this.name= name;
		this.author = author;
		this.publisher = publisher;
		this.genre = genre;
		this.isLoaned = isLoaned;
	}
	
	public int getId() {
		return book_id;
	}
	
	public void setid(int id) {
		this.book_id = id;
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

	public int getPublication_date() {
		return publication_date;
	}

	public void setPublication_date(int publication_date) {
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
		return "Book [id = " + book_id + ", name = " + name + ", author = " + author + ", "
				+ "publisher = " + publisher + ", genre = " + genre + ", loaned = " + isLoaned + "]";
	}
	
}
