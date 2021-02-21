package io.codekaffee.hrpayroll.clients;

import io.codekaffee.hrpayroll.models.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(url = "localhost:8001", path = "/workers", name = "hr-worker")
public interface WorkerFeignClient {
    @GetMapping("/{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id);
}
