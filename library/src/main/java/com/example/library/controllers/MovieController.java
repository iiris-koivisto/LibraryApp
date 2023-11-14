package com.example.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.library.models.Movie;
import com.example.library.repositories.MovieRepository; // Make sure to import the correct repository.

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/movies")
public class MovieController {
    
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable Integer id) {
        return movieRepository.findById(id).get();
    }

    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @PutMapping("/{id}")
    public Movie update(@RequestBody Movie movie, @PathVariable Integer id) {
        Movie m = movieRepository.findById(id).get();
        m.setName(movie.getName());
        m.setMovieStudio(movie.getMovieStudio());
        m.setGenre(movie.getGenre());
        return movieRepository.save(m);
    }

    @DeleteMapping("/{id}")
    public Movie delete(@PathVariable Integer id) {
        Movie m = movieRepository.findById(id).get();
        movieRepository.delete(m);
        return m;
    }
}
