package io.codekaffee.hrworker.repositories;

import io.codekaffee.hrworker.domain.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkrRepository extends JpaRepository<Worker, Long> {
}
