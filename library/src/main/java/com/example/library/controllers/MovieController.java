package com.example.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.library.models.Movie;

import java.util.*;

@RestController
public class MovieController {
	
	@Autowired
	private MovieRepository MovieRepository;

	@GetMapping(value = "/movies")
	public List<Movie> getAll() {
		return MovieRepository.findAll();
	}

	@GetMapping(value = "/movies/{id}")
	public Movie get(@PathVariable(name = "id") Integer id) {
		return MovieRepository.findById(id).get();
	}

	@PostMapping(value = "/movies")
	public Movie create(@RequestBody Movie movie) {
		return MovieRepository.save(movie);
	}

	@PutMapping(value = "/movies/{id}")
	public Movie update( @RequestBody Movie movie,
			@PathVariable(name = "id") Integer id) {
		Movie m = movieRepository.findById(id).get();
		m.setName(movie.getName());
		m.setMovieStudio(movie.getMovieStudio());
		m.setGenre(movie.getGenre());
		return movieRepository.save(m);
	}

	@DeleteMapping(value = "/users/{id}")
	public Movie delete(@PathVariable(name = "id") Integer id) {
		Movie m = movieRepository.findById(id).get();
		movieRepository.delete(m);
		return m;
	}
}