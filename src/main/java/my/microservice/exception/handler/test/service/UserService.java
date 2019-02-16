package my.microservice.exception.handler.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.microservice.exception.handler.test.domain.User;
import my.microservice.exception.handler.test.exception.UserNotFoundException;
import my.microservice.exception.handler.test.exception.UserNotUpdatedException;
import my.microservice.exception.handler.test.exception.UserValidationException;
import my.microservice.exception.handler.test.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	public List<User> getAllUsers() {
		
		List<User> usersList = repository.findAll();
		
		if(usersList == null || usersList.isEmpty()) {
			throw new UserNotFoundException(" User list is empty"); 
		}
		
		return usersList;
	}
	
	public User getUser(Long userId) {
		
		User user = repository.findOne(userId);
		
		if( user == null) {
			throw new UserNotFoundException(" User not found for the ID: "+userId);
		} 
		
		return user;
	}
	
	public User saveUser( User user) {
		
		User savedUser = repository.save(user);
		
		if( savedUser == null) {
			throw new UserNotFoundException(" Couldn't save the given user "+savedUser);
		}
		
		return savedUser;
	}
	
	public User updateUser( User user) {
		
		if( user == null || user.getId() <= 0) {
			throw new UserValidationException(" User or ID is null for updating "+user);
		}
		
		User updatedUser = repository.save(user);
		
		if( updatedUser == null) {
			throw new UserNotUpdatedException(" Couldn't update the given user "+updatedUser);
		}
		
		return updatedUser;
	}
	
	public boolean deleteUser( Long userId) {
		
		User user = repository.findOne(userId);
		
		if( user == null) {
			throw new UserNotFoundException(" User not found for the ID: "+userId);
		} else {
			repository.delete(userId);
			return true;
		}
			
	}
	
}
