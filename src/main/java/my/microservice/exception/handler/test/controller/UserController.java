package my.microservice.exception.handler.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import my.microservice.exception.handler.test.domain.User;
import my.microservice.exception.handler.test.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;
	
	@GetMapping("/users/{userid}")
	public ResponseEntity<User> getUser( @PathVariable Long userid) {
		return new ResponseEntity<>(service.getUser(userid),HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<>(service.getAllUsers(),HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser( @RequestBody User newuser) {
		return new ResponseEntity<>(service.saveUser(newuser),HttpStatus.CREATED);
	}
	
	@PutMapping("/users")
	public ResponseEntity<User> updateUser( @RequestBody User user) {
		return new ResponseEntity<>(service.updateUser(user),HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{userid}")
	public ResponseEntity<?> deleteUser( @PathVariable Long userid) {
		if( service.deleteUser(userid) ) {
			return new ResponseEntity<>(" Deleted the user successfully",HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(" Something went wrong while deleting the user",HttpStatus.BAD_REQUEST);
	}
	
}
