package projectOli.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectOli.model.request.HealthProblemRequest;
import projectOli.model.response.HealthProblemResponse;
import projectOli.service.HealthProblemService;

import java.util.Optional;


@RestController
@RequestMapping("/api/healthProblem")
public class HealthProblemController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HealthProblemController.class);
	
	@Autowired
	private HealthProblemService healthProblemService;
		
	@PostMapping
	public ResponseEntity<HealthProblemResponse> post(@RequestBody HealthProblemRequest healthProblemRequest){
		LOGGER.info("Data accepted");
		return ResponseEntity.ok(healthProblemService.post(healthProblemRequest));
	};
	
	@GetMapping
	public ResponseEntity<Page<HealthProblemResponse>> getAll(Pageable pageable){
		LOGGER.info("Searching all Health Problems");
		Page<HealthProblemResponse> healthProblemResponses = healthProblemService.getAll(pageable);
		return ResponseEntity.ok(healthProblemResponses);

	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<HealthProblemResponse> update(@PathVariable("id") Long id, @RequestBody HealthProblemRequest healthProblemRequest){
		LOGGER.info("Updating infs");
		Optional<HealthProblemResponse> update = healthProblemService.update(id, healthProblemRequest);
		if (!update.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(update.get());
	}

}
