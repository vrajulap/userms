package com.venkat.userms.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.userms.model.User;
import com.venkat.userms.service.UserService;

@RestController
public class UserResource {
	private final UserService userService;

	public UserResource(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<?> getAllUsers(@PathVariable Long userId) {
		Optional<User> user = userService.getSingleUser(userId);
		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping("/users")
	public ResponseEntity<?> createUser(@RequestBody User user) throws URISyntaxException {
		User userCreated = userService.createUser(user);
		return ResponseEntity.created(new URI(userCreated.getId().toString())).build();
	}
}
