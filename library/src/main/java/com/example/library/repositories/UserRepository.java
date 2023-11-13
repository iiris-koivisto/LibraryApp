package com.example.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.library.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
}
