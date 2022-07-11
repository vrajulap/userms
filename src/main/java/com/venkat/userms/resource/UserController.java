package com.venkat.userms.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.userms.model.User;
import com.venkat.userms.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Long userId) {
		Optional<User> user = userService.getUserById(userId);
		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping("/users")
	public ResponseEntity<?> createUser(@RequestBody User user) throws URISyntaxException {
		User userCreated = userService.createUser(user);
		return ResponseEntity.created(new URI(userCreated.getUserId().toString())).build();
	}

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return ResponseEntity.ok("User with Id " + userId + " deleted successfully");
	}
}
