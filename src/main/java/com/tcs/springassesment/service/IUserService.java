package com.tcs.springassesment.service;

import javax.validation.Valid;

import com.tcs.springassesment.entity.User;


public interface IUserService {

	User saveUser(@Valid User user);

	Iterable<User> getAll();

	void deleteUser(Integer id);

	User updateUser(Integer id, User user);

	

}
