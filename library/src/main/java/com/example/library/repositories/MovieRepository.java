package com.example.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.library.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
}