package com.example.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.library.models.Loan;
import com.example.library.repositories.LoanRepository;
import com.example.library.repositories.BookRepository;
import com.example.library.repositories.MovieRepository;
import com.example.library.repositories.UserRepository;
import com.example.library.repositories.EmployeeRepository;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/loans")
public class LoanController {
	
	@Autowired
	private LoanRepository loanRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping
	public List<Loan> getAllLoans() {
		return loanRepository.findAll();
	}

	@GetMapping("/{id}")
	public Loan getLoanById(@PathVariable int id) {
	    // findById returns an Optional<Loan>
        return loanRepository.findById(id).orElse(null);
    }
	
	//Search loans with book_id
	@GetMapping("/book/{book_id}")
	public List<Loan> getLoanByBookId(@PathVariable int book_id) { 
        return loanRepository.getLoanByBookId(book_id);
    }
	
	//Search loans with movie_id
	@GetMapping("/movie/{movie_id}")
	public List<Loan> getLoanByMovieId(@PathVariable int movie_id) { 
	    return loanRepository.getLoanByMovieId(movie_id);
	}
	
	//Search loans with user_id, returns only active loans
	@GetMapping("/user/{user_id}")
	public List<Loan> getLoanByUserId(@PathVariable int user_id) { 
		return loanRepository.getLoanByUserId(user_id);
	}

    @PostMapping("/loans")
    public Loan addLoan(@RequestBody Loan loan) {
        // Validate if the user, book/movie, and employee exist
        if (!userRepository.existsById(loan.getUserId()) ||
            (loan.getBookId() != 0 && !bookRepository.existsById(loan.getBookId())) ||
            (loan.getMovieId() != 0 && !movieRepository.existsById(loan.getMovieId())) ||
            !employeeRepository.existsById(loan.getEmployeeId())) {
            return null; // or throw an exception
        }

        // Set isReturned to false when creating a new loan
        loan.setIsReturned(false);

        // Your existing logic for saving the loan
        return loanRepository.save(loan);
    }

	@PutMapping("/{id}")
	public Loan updateLoan( @RequestBody Loan updatedLoan,
			@PathVariable int id) {
		// Check if the loan with the given ID exists
        return loanRepository.findById(id)
                .map(loan -> {
                    // Set the ID of the updated employee
                    updatedLoan.setId(id);
                    // Save the updated employee to the database
                    return loanRepository.save(updatedLoan);
                })
                .orElse(null);
    }

	@DeleteMapping("/{id}")
	public void deleteLoan(@PathVariable int id) {
	    // Delete the loan with the given ID from the database
        loanRepository.deleteById(id);
    }
	
    @PutMapping("/loans/{id}/return")
    public Loan returnLoan(@PathVariable int id) {
        Optional<Loan> optionalLoan = loanRepository.findById(id);

        if (optionalLoan.isPresent()) {
            Loan loan = optionalLoan.get();
            loan.setIsReturned(true);
            // Your logic for any additional actions when returning a loan
            return loanRepository.save(loan);
        } else {
            return null; // or throw an exception
        }
    }

}
