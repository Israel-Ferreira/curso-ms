package io.codekaffee.hrpayroll.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.codekaffee.hrpayroll.models.Payment;



@Service
public class MockService {

    public Payment getRandomPayment(Long workerId, int days){
        var payments = this.getPayments(days);
        Integer index = (int) (Math.random() * (payments.size() - 0) + 0);
        return payments.get(index);
    }


    private List<Payment> getPayments(int days){ 
        return Arrays.asList(
            new Payment("Francisco José", 1300.00, days),
            new Payment("Paulo Franco", 250.00, days),
            new Payment("Juan Jaime", 350.00, days),
            new Payment("Beatriz Castro Neves", 450.00, days)
        );
    }


}
