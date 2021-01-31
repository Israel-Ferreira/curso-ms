package io.codekaffee.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.codekaffee.hrpayroll.models.Payment;

@Service
public class PaymentService {

    @Autowired
    private MockService mockService;

    public Payment getPayment(Long workerId, int days){
        return mockService.getRandomPayment(workerId, days) ;
    }
}
