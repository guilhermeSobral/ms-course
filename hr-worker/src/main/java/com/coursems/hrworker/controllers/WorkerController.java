package com.coursems.hrworker.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coursems.hrworker.entities.Worker;
import com.coursems.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping("/workers")
public class WorkerController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(WorkerController.class);
	
	@Autowired
	private WorkerRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAllWorkers() {
		var worker = repository.findAll();
		return ResponseEntity.ok().body(worker);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> findWorker(@PathVariable Long id) {
		logger.info("PORT = " + env.getProperty("local.server.port"));
		var worker = repository.findById(id).get();
		return ResponseEntity.ok().body(worker);
	}

}
