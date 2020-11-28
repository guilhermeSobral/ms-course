package com.mscourse.hroauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mscourse.hroauth.entities.User;

@Component
@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClient {
	
	@GetMapping("/search")
	public ResponseEntity<User> findUserByEmail(@RequestParam String email);

}
