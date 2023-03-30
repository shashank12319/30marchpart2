package com.wittybrains.busbookingsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.wittybrains.busbookingsystem.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
//	User createUser(User user);
//    User getUser(Long userId);
//    User updateUser(Long userId, User user);
//    void deleteUser(Long userId);
//    Optional<User> findByUsername(String username);
	
	Optional<User> findById(Long userId);
}

