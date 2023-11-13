package com.example.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.library.models.User;
import com.example.library.repositories.UserRepository;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = "/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id) {
	    // findById returns an Optional<User>
        return userRepository.findById(id).orElse(null);
    }

	@PostMapping
	public User addUser(@RequestBody User user) {
		  // Save the new user to the database
        return userRepository.save(user);
    }

	@PutMapping("/{id}")
	public User updateUser( @RequestBody User updatedUser,
			@PathVariable int id) {
		// Check if the user with the given ID exists
        return userRepository.findById(id)
                .map(user -> {
                    // Set the ID of the updated employee
                    updatedUser.setId(id);
                    // Save the updated employee to the database
                    return userRepository.save(updatedUser);
                })
                .orElse(null);
    }

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) {
	    // Delete the user with the given ID from the database
        userRepository.deleteById(id);
    }
}
