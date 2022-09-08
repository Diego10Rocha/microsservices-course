package com.microsservices.course.hrpayroll.services;

import com.microsservices.course.hrpayroll.models.Payment;
import com.microsservices.course.hrpayroll.models.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    private final RestTemplate restTemplate;

    @Value("${hr-worker.host}")
    private String workerHost;

    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment getPayment(long workerId, int days) throws Exception {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", "" + workerId);
        String url = String.format("%s/workers/{id}", workerHost);
        Worker worker = restTemplate.getForObject(url, Worker.class, uriVariables);
        if (worker == null) {
            throw new Exception("worker not found!");
        }
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
