package com.venkat.userms.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.venkat.userms.model.User;
import com.venkat.userms.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		LOGGER.info("************");
		LOGGER.info("getting all users");
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getSingleUser(Long userId) {
		LOGGER.info("************");
		LOGGER.info("getting single user");
		return userRepository.findById(userId);
	}

	@Override
	public User createUser(User user) {
		User userCreated = userRepository.save(user);
		return userCreated;
	}

	@Override
	public void updateUser(User user) {

	}

	@Override
	public void deleteUser(Long userId) {

	}
}
