package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.MyUserDetails;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	public void createNewUser(User u) {
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		 String pass=bc.encode(u.getPassword());
		 u.setPassword(pass);
		userRepository.save(u);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();

	}
	
   public User getUser(String userName)
   {
	  MyUserDetails m=(MyUserDetails) myUserDetailsService.loadUserByUsername(userName);
	   return  m.getUser();
	  /*User u= userRepository.findByUserName(userName);
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();

	   if((bc.matches(password,u.getPassword())))
		   {
		  return  u;
		   }
	   return null;
	   */
   }
}
