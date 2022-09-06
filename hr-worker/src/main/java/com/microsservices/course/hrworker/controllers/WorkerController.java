package com.microsservices.course.hrworker.controllers;

import java.util.List;
import java.util.Optional;

import com.microsservices.course.hrworker.models.Worker;
import com.microsservices.course.hrworker.services.WorkerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/workers")
public class WorkerController {

	private final WorkerService workerService;

	public WorkerController(WorkerService workerService) {
		this.workerService = workerService;
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> workers = workerService.findAll();
		return ResponseEntity.ok().body(workers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> findAll(@PathVariable Long id) {
		Worker worker = workerService.findById(id);
		if (worker == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(worker);
	}
}
