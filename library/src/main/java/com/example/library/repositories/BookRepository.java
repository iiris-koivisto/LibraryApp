package com.example.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.library.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}