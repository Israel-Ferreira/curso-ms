package io.codekaffee.hrworker.resources;

import io.codekaffee.hrworker.domain.Worker;
import io.codekaffee.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> getWorkers(){
        var workers = workerRepository.findAll();
        return ResponseEntity.ok(workers);
    }

    @PostMapping
    public ResponseEntity<?> createWorker(@RequestBody Worker worker){
        Worker savedWorker =  workerRepository.save(worker);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + savedWorker.getId())
                .build().toUri();

        return ResponseEntity.created(uri).body(savedWorker);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Worker> getById(@PathVariable Long id){
        Worker worker = workerRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(worker);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        workerRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
