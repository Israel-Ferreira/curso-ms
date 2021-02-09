package io.codekaffee.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.codekaffee.hrpayroll.exceptions.WorkerNotFoundException;
import io.codekaffee.hrpayroll.models.Payment;
import io.codekaffee.hrpayroll.models.Worker;

@Service
public class PaymentService {


    @Value("${worker.endpoint}")
    private String workerUrl;


    @Autowired
    private RestTemplate restTemplate;


    public Payment getPayment(Long workerId, int days){
        String url =  workerUrl + "/{id}";

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", ""+workerId);


        var workerResponse = this.restTemplate.getForEntity(url, Worker.class, uriVariables);

        HttpStatus statusCode = workerResponse.getStatusCode();
        
        if(statusCode.is4xxClientError() || statusCode.is5xxServerError()){
            throw new WorkerNotFoundException();
        }


        Worker worker =  workerResponse.getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
