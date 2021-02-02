package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.service.MyUserDetailsService;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserDetailsService();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}
	/*@Override
    protected void configure(HttpSecurity http) throws Exception {
		//http.csrf().disable();
		http.authorizeRequests()
        .anyRequest().authenticated()
        		.and()
        		.formLogin().permitAll()
				.and()
				.logout().permitAll();
		    } */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	http.authorizeRequests()
		.antMatchers("/getAllUsers").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("USER","ADMIN")
		.antMatchers("/").permitAll();//anyRequest().authenticated()
		//.and().httpBasic();

}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	web.ignoring().antMatchers("/signUp");
	//web.ignoring().antMatchers("/getAllUsers");

	web.ignoring().antMatchers("/v2/api-docs");
	web.ignoring().antMatchers("/swagger-ui.html");
	web.ignoring().antMatchers("/swagger-resources/**");
	web.ignoring().antMatchers("/swagger.json");
	web.ignoring().antMatchers("/webjars/**");
	}

}
