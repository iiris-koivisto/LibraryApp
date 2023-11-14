package com.example.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.library.models.Loan;
import com.example.library.repositories.LoanRepository;

import java.util.*;

public class LoanController {
	
	@Autowired
	private LoanRepository loanRepository;
	
	@GetMapping(value = "/loans")
	public List<Loan> getAllLoans() {
		return loanRepository.findAll();
	}

	@GetMapping("/{id}")
	public Loan getLoanById(@PathVariable int id) {
	    // findById returns an Optional<Loan>
        return loanRepository.findById(id).orElse(null);
    }

	@PostMapping
	public Loan addLoan(@RequestBody Loan loan) {
		  // Save the new loan to the database
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

}
