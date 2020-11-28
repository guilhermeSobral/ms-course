package com.mscourse.hruser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mscourse.hruser.entities.User;
import com.mscourse.hruser.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findUser(@PathVariable Long id) {
		var user = userRepo.findById(id).get();
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping("/search")
	public ResponseEntity<User> findUserByEmail(@RequestParam String email) {
		var user = userRepo.findByEmail(email);
		return ResponseEntity.ok().body(user);
	}

}
