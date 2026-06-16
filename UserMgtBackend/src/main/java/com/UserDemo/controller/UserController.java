package com.UserDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.UserDemo.Dao.UserDao;
import com.UserDemo.Exception.UserNotFoundException;
import com.UserDemo.Model.User;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@PostMapping("/user")
	User newUser(@RequestBody User newUser)
	{
		return userDao.save(newUser);
	}
	
	
	@GetMapping("/users")
	List<User> getAllUsers()
	{
		return userDao.findAll();
	}

	
	@GetMapping("/user/{id}")
	User getUsersbyId(@PathVariable Long id)
	{
		return userDao.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}
	
	@PutMapping("/user/{id}")
	User updateUser(@RequestBody User newUser , @PathVariable Long id)
	{
		return userDao.findById(id)
				.map(user -> {
					user.setUsername(newUser.getUsername());
					user.setName(newUser.getName());
					user.setEmail(newUser.getEmail());
			        return userDao.save(user);	
				}).orElseThrow(() -> new UserNotFoundException(id));
		}
	
	@DeleteMapping("/user/{id}")
	String deleteUser(@PathVariable Long id)
	{
		if(!userDao.existsById(id))
		{
			throw new UserNotFoundException(id);
		}
		userDao.deleteById(id);
		return "User with id " +id+ " has been deleted success.";
	}
}
