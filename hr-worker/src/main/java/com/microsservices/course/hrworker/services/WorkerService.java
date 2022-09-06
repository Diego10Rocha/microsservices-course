package com.microsservices.course.hrworker.services;

import com.microsservices.course.hrworker.models.Worker;
import com.microsservices.course.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    public Worker findById(@PathVariable Long id) {
        Optional<Worker> worker = workerRepository.findById(id);
        return worker.orElse(null);
    }
}
