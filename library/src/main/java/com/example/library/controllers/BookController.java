package com.example.library.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.library.models.Book;
import com.example.library.repositories.BookRepository; // Make sure to import the correct repository.

import java.util.List;

@RestController
@CrossOrigin(origins = "http//localhost:4200")
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Book getBook(@PathVariable Integer id) {
		return bookRepository.findById(id).get();
	}
	
	@PostMapping
	public Book addBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	@PutMapping("/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable Integer id) {
		Book b = bookRepository.findById(id).get();
		b.setName(book.getName());
		b.setAuthor(book.getAuthor());
		b.setPublisher(book.getPublisher());
		b.setGenre(book.getGenre());
		return bookRepository.save(b);
	}
	
	@DeleteMapping("/id")
	public Book deleteBook(@PathVariable Integer id) {
		Book b = bookRepository.findById(id).get();
		bookRepository.delete(b);
		return b;
	}
}
