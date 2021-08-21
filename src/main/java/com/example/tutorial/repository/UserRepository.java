package com.example.tutorial.repository;

import org.springframework.data.repository.UserRepository;
import com.example.tutorial.model.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends UserRepository<User, Integer> {

}