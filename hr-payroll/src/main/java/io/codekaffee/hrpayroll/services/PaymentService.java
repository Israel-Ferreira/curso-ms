package io.codekaffee.hrpayroll.services;

import io.codekaffee.hrpayroll.clients.WorkerFeignClient;
import io.codekaffee.hrpayroll.exceptions.WorkerNotFoundException;
import io.codekaffee.hrpayroll.models.Payment;
import io.codekaffee.hrpayroll.models.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;


    private void checkStatusCode(ResponseEntity<?> response){
        if(response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError()){
            throw new WorkerNotFoundException();
        }
    }

    public Payment getPayment(Long workerId, int days){
        var workerResponse = this.workerFeignClient.findById(workerId);

        this.checkStatusCode(workerResponse);
        Worker worker =  workerResponse.getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
