package com.cg.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.AuthenticationService.dao.UserEntity;
@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user = userRepo.findByUserName(username);
		
		return new UserPrincipal(user);
	}

	
}
