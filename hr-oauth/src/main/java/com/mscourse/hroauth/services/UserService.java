package com.mscourse.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mscourse.hroauth.clients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserFeignClient client;	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = client.findUserByEmail(username).getBody();
		if(user == null)
			throw new UsernameNotFoundException("User not found");
		return user;
	}
}
