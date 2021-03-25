package io.codekaffee.hrworker.resources;

import io.codekaffee.hrworker.domain.Worker;


import io.codekaffee.hrworker.repositories.WorkrRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static Logger log = LoggerFactory.getLogger(WorkerResource.class);

    @Autowired
    private WorkrRepository workrRepository;

    @Autowired
    private Environment env;

    @Value("${test.config}")
    private String testConfig;

    @GetMapping
    public ResponseEntity<List<Worker>> getWorkers(){
        var workers = workrRepository.findAll();
        return ResponseEntity.ok(workers);
    }


    @GetMapping("/configs")
    public ResponseEntity<Void> getConfigs(){
        log.info("CONFIG= " + testConfig );
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    public ResponseEntity<?> createWorker(@RequestBody Worker worker){
        Worker savedWorker =  workrRepository.save(worker);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + savedWorker.getId())
                .build().toUri();

        return ResponseEntity.created(uri).body(savedWorker);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Worker> getById(@PathVariable Long id){
        Worker worker = workrRepository.findById(id).orElseThrow();

        System.out.println(env.getProperty("local.server.port"));

        log.info("PORT=" + env.getProperty("local.server.port"));
        return ResponseEntity.ok(worker);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        workrRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
