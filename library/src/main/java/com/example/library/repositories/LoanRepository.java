package com.example.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.library.models.Loan;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer>{

	@Query("SELECT l FROM Loans WHERE " +
			"l.book_id = :book_id ")
	List<Loan> getLoanByBookId(@Param("book_id")int book_id);
	
	
	@Query("SELECT l FROM Loans WHERE " +
			"l.movie_id = :movie_id ")
	List<Loan> getLoanByMovieId(@Param("movie_id")int movie_id);
	
	
	@Query("SELECT l FROM Loans WHERE " +
			"l.user_id = :user_id " +
			"AND isReturned = false")
	List<Loan> getLoanByUserId(@Param("user_id")int user_id);
	
	@Query("SELECT l FROM Loans WHERE " +
			"l.employee_id = :employee_id " +
			"AND isReturned = false")
	List<Loan> getLoanByEmployeeId(@Param("employee_id")int employee_id);
}