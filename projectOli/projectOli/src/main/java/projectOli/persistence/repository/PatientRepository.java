package projectOli.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projectOli.persistence.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	
}
