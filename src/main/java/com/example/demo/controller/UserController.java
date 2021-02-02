package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

@Autowired
private UserService userService;

@GetMapping("/")
public String getAny()
{
	return "welcome";
}

@GetMapping("/getAllUsers")
public List<User> getAllUsers()
{
	return userService.getAllUsers();
}

@PostMapping("/signUp")
public void userSignUp(@RequestBody User u) 
{
	userService.createNewUser(u);
}
@GetMapping("/user")
public String welcome()
{
	return "welcome user";

}
@GetMapping("/getUser")
public User getUserByName(@RequestParam String userName)
{
	return userService.getUser(userName);
}
}
