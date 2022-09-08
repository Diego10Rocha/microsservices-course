package com.microsservices.course.hrpayroll.services;

import com.microsservices.course.hrpayroll.models.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days) {

        return new Payment("Diego", 200.0, days);
    }
}
