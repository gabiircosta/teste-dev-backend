package projectOli.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projectOli.persistence.entity.HealthProblem;

public interface HealthProblemRepository extends JpaRepository<HealthProblem, Long>{

}
