package com.example.tutorial.controller;

import com.example.tutorial.exception.ResourceNotFoundException;
import com.example.tutorial.model.User;
import com.example.tutorial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> findUserById(@PathVariable(value = "id") long id) {
    Optional<User> user = userRepository.findById(id);

    if(user.isPresent()) {
      return ResponseEntity.ok().body(user.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public User saveUser(@Validated @RequestBody User user) {
    return userRepository.save(user);
  }

}
