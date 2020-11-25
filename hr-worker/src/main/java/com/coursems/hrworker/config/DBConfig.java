package com.coursems.hrworker.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coursems.hrworker.entities.Worker;
import com.coursems.hrworker.repositories.WorkerRepository;

@Configuration
public class DBConfig {
	
	@Autowired
	private WorkerRepository repository;
	
	@Bean
	public void initDB() {
		var w1 = new Worker("Worker 1", 100.0);
		var w2 = new Worker("Worker 2", 200.0);
		var w3 = new Worker("Worker 3", 300.0);
		
		repository.saveAll(Arrays.asList(w1,w2,w3));
	}

}
