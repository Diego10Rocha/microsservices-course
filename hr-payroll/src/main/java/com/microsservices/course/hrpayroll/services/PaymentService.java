package com.microsservices.course.hrpayroll.services;

import com.microsservices.course.hrpayroll.feignclients.WorkerFeignClient;
import com.microsservices.course.hrpayroll.models.Payment;
import com.microsservices.course.hrpayroll.models.Worker;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final WorkerFeignClient workerFeignClient;

    public PaymentService(WorkerFeignClient workerFeignClient) {
        this.workerFeignClient = workerFeignClient;
    }


    public Payment getPayment(long workerId, int days) throws Exception {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        if (worker == null) {
            throw new Exception("worker not found!");
        }
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
