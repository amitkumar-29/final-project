package com.tcs.springassesment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.springassesment.entity.User;
import com.tcs.springassesment.exception.UserNotFoundException;
import com.tcs.springassesment.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserControl {

	@Autowired
	IUserService userService;
	@PostMapping
	public User savedUser(@Valid @RequestBody User user) {
		return userService.saveUser(user);	
	}
	@GetMapping
	public Iterable<User> getAllUser() {
		return userService.getAll();
	}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
	}
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Integer id,@RequestBody User user) {
		return userService.updateUser(id,user);
	}
	@ExceptionHandler(value = UserNotFoundException.class)
	   public ResponseEntity<User> exception(RuntimeException runTimeException) {
	      return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	   }
}
