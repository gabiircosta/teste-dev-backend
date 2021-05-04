package projectOli.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectOli.model.request.HealthProblemRequest;
import projectOli.model.response.HealthProblemResponse;

import java.util.Optional;

public interface HealthProblemService {
	
	HealthProblemResponse post (HealthProblemRequest healthProblemRequest);
	
	Page<HealthProblemResponse> getAll (Pageable pageable);
	
	Optional<HealthProblemResponse> update (Long id, HealthProblemRequest healthProblemRequest);

}
