package com.example.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.library.models.User;
import com.example.library.repositories.UserRepository;

import java.util.*;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	private List<User> userList = new ArrayList <>();
	
	@GetMapping(value = "/users")
	public List<User> getAllUsers() {
		return userList;
	}

	@GetMapping(value = "/users/{id}")
	public User getUserById(@PathVariable(name = "id") int id) {
		// Find the user with the given ID
		for (User user : userList) {
			if (user.getId() == id) {
				return user;
			}
		}
		// Return null if no user is found
		return null;
	}

	@PostMapping(value = "/users")
	public User create(@RequestBody User user) {
		// Assign a unique ID (you might want to use a more sophisticated ID generation strategy)
        int nextId = userList.size() + 1;
        user.setId(nextId);

        // Add the new employee to the list
        userList.add(user);

        // Return the newly added employee
        return user;
	}

	@PutMapping(value = "users/{id}")
	public User updateUser( @RequestBody User updatedUser,
			@PathVariable int id) {
		for (User user : userList) {
			if (user.getId() == id) {
				//Update user details
				user.setName(updatedUser.getName());
				user.setEmail(updatedUser.getEmail());
				user.setAddress(updatedUser.getAddress());
				user.setPhoneNumber(updatedUser.getPhoneNumber());
				
				//Return updated user
				return userRepository.save(user);
			}
		}
		//Return null if no user is found
		return null;
	}

	@DeleteMapping(value = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userList.removeIf(user -> user.getId() == id);
	}
}
