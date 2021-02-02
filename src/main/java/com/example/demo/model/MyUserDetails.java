package com.example.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
	
	@Autowired
	private User user;
//	public MyUserDetails(User user) {
	//this.user = user;
	//}
	private String userName;
	private String password;
	private List<GrantedAuthority>Authorities;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	return Authorities;
	}

	@Override
	public String getPassword() {
	return password;
	}

	
	@Override
	public String getUsername() {
	return userName;
	}

	public MyUserDetails(User u) {
		this.user= u;
		this.userName = u.getUserName();
		this.password = u.getPassword();
		List<GrantedAuthority> gl = new ArrayList<GrantedAuthority>();
		String[] s1=u.getAuthorities().split(",");
		for(String s:s1)
		{
			gl.add(new SimpleGrantedAuthority(s));
			System.out.println(gl);
		}
		this.Authorities=gl;
		
		//String []s=u.getAuthorities().split(",");
		//this.Authorities=AuthorityUtils.commaSeparatedStringToAuthorityList(u.getAuthorities());
		
		
	}
	
	@Override
	public boolean isAccountNonExpired() {
	
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
	return true;
	}

	@Override
	public boolean isEnabled() {
	return true;
	}

	public User getUser()
	{
		return user;
	}
				
}
