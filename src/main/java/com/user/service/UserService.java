package com.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.exception.NoSuchUserExistsException;
import com.user.exception.UserAlreadyExistsException;
import com.user.model.User;
import com.user.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	public User addUser(@RequestBody User user) {

//		check if customer already exist
		if (userRepo.existsByMobNum(user.getMobNum())) {
			throw new UserAlreadyExistsException(
					"Customer already exists with the mobile number- " + user.getMobNum());
		}

		else if (userRepo.existsByEmail(user.getEmail())) {
			throw new UserAlreadyExistsException("User already exists with email- " + user.getEmail());
		}

		else {
			return userRepo.save(user);
		}
	}

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	public User getUserById(@PathVariable Integer id) {
		return userRepo.findById(id)
				.orElseThrow(() -> new NoSuchUserExistsException("No user present with id = " + id));
	}
	
	public ResponseEntity<User> updateUserById(@RequestBody User user, @PathVariable Integer id) {
		if (userRepo.existsById(id)) {
			User existingUser = userRepo.findById(id).get();
			existingUser.setName(user.getName());
			existingUser.setMobNum(user.getMobNum());
			existingUser.setEmail(user.getEmail());
			existingUser.setAddress(user.getAddress());
			userRepo.save(existingUser);
			return ResponseEntity.ok(existingUser);
		} else {
			throw new NoSuchUserExistsException("No such user exists!");
		}
	}
	
	public ResponseEntity<Map<String, Boolean>> deleteUserById(@PathVariable Integer id) {
		if (userRepo.existsById(id)) {
			userRepo.deleteById(id);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);		
		}

		else {
			throw new NoSuchUserExistsException("No user exist with id = "+id);
		}
	}

}
