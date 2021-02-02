package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="user")
public class User {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
private String userName;
private String password;
private String authorities;
//private String firstName;
//private String lastName;
//private String Email;



/*public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
*/
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public User(Integer id, String userName, String password,String authorities) {
	super();
	this.id = id;
	this.userName = userName;
	this.password = password;
	this.authorities=authorities;
}

@Override
public String toString() {
	return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", authorities=" + authorities
			+ "]";
}
public String getAuthorities() {
	return authorities;
}
public void setAuthorities(String authorities) {
	this.authorities = authorities;
}
public User() {
	super();
}


/*public String getRoles() {
	return roles;
}
public void setRoles(String roles) {
	this.roles = roles;
}
public User(Integer id, String userName, String password, String roles,boolean active) {
	this.id = id;
	this.userName = userName;
	this.password = password;
	this.roles = roles;
	this.active=active;
}
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}*/

}
