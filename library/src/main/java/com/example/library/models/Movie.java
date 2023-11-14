package com.example.library.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movie_id;
	private String name;
	private String movieStudio;
	private String genre;
	private boolean isLoaned;
	
	public Movie(int id, String name, String movieStudio, String genre, boolean isLoaned) {
		super();
		this.movie_id = id;
		this.name = name;
		this.movieStudio = movieStudio;
		this.genre = genre;
		this.isLoaned = isLoaned;
	}
	
	public int getId() {
		return movie_id;
	}
	
	public void setId(int id) {
		this.movie_id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}
	
	public String getMovieStudio() {
		return movieStudio;
	}

	public void setMovieStudio(String movieStudio) {
		this.movieStudio = movieStudio;
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

		return "Movie [id = " + movie_id + ", name = " + name + ", movie studio = " + movieStudio + ", "
				+ "genre = " + genre + ", Loaned = " + isLoaned + "]";

	}
}
