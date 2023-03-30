package com.wittybrains.busbookingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wittybrains.busbookingsystem.dto.UserDTO;
import com.wittybrains.busbookingsystem.model.User;
import com.wittybrains.busbookingsystem.repository.UserRepository;

@Service
public class UserService {

	

	    @Autowired
	    private UserRepository userRepository;
	    
	    public UserDTO createUser(UserDTO userDTO) {
	        User user = new User();
	        user.setUsername(userDTO.getUsername());
	        user.setPassword(userDTO.getPassword());
	        user.setPhoneNumber(userDTO.getPhoneNumber());
	        user.setEmail(userDTO.getEmail());
	        user.setCity(userDTO.getCity());
	        user.setAddress(userDTO.getAddress());
	        user.setCountry(userDTO.getCountry());
	        
//	        List<Booking> bookings = userDTO.getBookings().stream()
//	                .map(dto -> new Booking())
//	                .collect(Collectors.toList());
//	        user.setBookings(bookings);

	        User createdUser = userRepository.save(user);
	       
	        return new UserDTO(createdUser);
	    }

	   
	
	    public UserDTO getUser(Long userId) {
	        User user = userRepository.findById(userId).orElseThrow();
	        return new UserDTO(user);
	    }

	    public UserDTO updateUser(Long userId, UserDTO userDTO) {
	        User user = userRepository.findById(userId).orElseThrow();
	        user.setUsername(userDTO.getUsername());
	        user.setPassword(userDTO.getPassword());
	        user.setPhoneNumber(userDTO.getPhoneNumber());
	        user.setEmail(userDTO.getEmail());
	        user.setCity(userDTO.getCity());
	        user.setAddress(userDTO.getAddress());
	        user.setCountry(userDTO.getCountry());

	        User updatedUser = userRepository.save(user);
	        return new UserDTO(updatedUser);
	    }


    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    
}

