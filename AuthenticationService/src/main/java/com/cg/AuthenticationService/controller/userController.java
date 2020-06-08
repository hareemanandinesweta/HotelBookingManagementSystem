package com.cg.AuthenticationService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.AuthenticationService.service.MyUserDetailsService;

@RestController
@CrossOrigin(origins="*")
public class userController {
	@Autowired
	private MyUserDetailsService serv;
	@GetMapping("/login")
	public UserDetails login(String user)
	{
		return serv.loadUserByUsername(user);
	}
		
	
	
}
