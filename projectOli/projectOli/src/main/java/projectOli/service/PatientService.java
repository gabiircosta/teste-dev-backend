package projectOli.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectOli.model.request.PatientRequest;
import projectOli.model.response.PatientResponse;

import java.util.Map;
import java.util.Optional;

public interface PatientService {
	
	PatientResponse post(PatientRequest patientRequest);
	
	Page<PatientResponse> getAll (Pageable pageable);
	
	Optional<PatientResponse> get(Long id);
	
	Optional<PatientResponse> update(Long id,  PatientRequest patientRequest);
	
	public boolean delete(Long id);
	
	Map<String, Integer> getByRanking();

}