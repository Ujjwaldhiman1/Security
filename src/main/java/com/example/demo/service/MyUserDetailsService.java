package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.MyUserDetails;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	
@Autowired
private UserRepository userRepository;

//@Autowired
//private BCryptPasswordEncoder bCryptPasswordEncoder;

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	//Optional<User> u 
	User u = userRepository.findByUserName(username);
	//String pass = bCryptPasswordEncoder.encode(u.getPassword());
	//u.setPassword(pass);
	return new MyUserDetails(u);

	}
}