package com.mscourse.hruser.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mscourse.hruser.entities.Role;
import com.mscourse.hruser.entities.User;
import com.mscourse.hruser.repositories.RoleRepository;
import com.mscourse.hruser.repositories.UserRepository;

@Configuration
public class AppConfig {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public void initDB() {
		var u1 = new User("User 1", "user1@gmail.com", passwordEncoder().encode("123"));	
		var u2 = new User("User 2 ", "user2@gmail.com", passwordEncoder().encode("456"));	
		
		var r1 = new Role("ROLE_OPERATOR");
		var r2 = new Role("ROLE_ADMIN");
		
		u1.getRoles().add(r1);
		u2.getRoles().add(r1);
		u2.getRoles().add(r2);
		
		roleRepo.saveAll(Arrays.asList(r1,r2));
		userRepo.saveAll(Arrays.asList(u1,u2));
	}
}
