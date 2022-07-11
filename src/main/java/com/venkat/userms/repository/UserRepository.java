package com.venkat.userms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venkat.userms.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
