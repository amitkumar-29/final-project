package com.tcs.springassesment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tcs.springassesment.entity.User;
import com.tcs.springassesment.exception.UserNotFoundException;
import com.tcs.springassesment.repository.IUserRepository;



@Service
public class UserService implements IUserService {
	@Autowired
	IUserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	@Override
	public Iterable<User> getAll() {
	return userRepository.findAll();
	}
	
	@Override
	public void deleteUser(Integer id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("appointment does not exist");
		}
		userRepository.deleteById(id);
		
	}
	
	@Override
	public User updateUser(Integer id,User user1) {
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("appointment does not exist");
		}
		User us=user.get();
		if(StringUtils.hasText(user1.getName())) {
			us.setName(user1.getName());
		}
		return userRepository.save(us);
	}
}
