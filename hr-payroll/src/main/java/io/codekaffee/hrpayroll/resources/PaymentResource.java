package io.codekaffee.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.codekaffee.hrpayroll.models.Payment;
import io.codekaffee.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;


    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getWorkerPayment(@PathVariable("workerId") Long workerId, @PathVariable("days") Integer days){ 
        Payment workerPayment = paymentService.getPayment(workerId, days);
        return ResponseEntity.ok(workerPayment);
    }
}
