package com.microsservices.course.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microsservices.course.hrworker.models.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
