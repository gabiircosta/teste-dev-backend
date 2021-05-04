package projectOli.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectOli.model.request.PatientRequest;
import projectOli.model.response.PatientResponse;
import projectOli.service.PatientService;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PatientController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping
	public ResponseEntity<PatientResponse> post(@RequestBody PatientRequest patientRequest){
		LOGGER.info("Data accepted");
		return ResponseEntity.ok(patientService.post(patientRequest));
	};
	
	@GetMapping
	public ResponseEntity<Page<PatientResponse>> getAll(Pageable pageable){
		LOGGER.info("Searching all patients");
		Page<PatientResponse> patientResponses = patientService.getAll(pageable);
		return ResponseEntity.ok(patientResponses);

	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<PatientResponse> get (@PathVariable("id") Long id){
		LOGGER.info("Searching patient by id");
		Optional<PatientResponse> patientResponse = patientService.get(id);
		if (!patientResponse.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(patientResponse.get());
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<PatientResponse> update(@PathVariable("id") Long id, @RequestBody PatientRequest patientRequest){
		LOGGER.info("Updating infs");
		Optional<PatientResponse> update = patientService.update(id, patientRequest);
		if (!update.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(update.get());
	}
	
	@GetMapping ("/{score}")
	public ResponseEntity<Map<String, Integer>> getScore(){
		LOGGER.info("Getting Scores");
		Map<String, Integer> patientScore = patientService.getByRanking();
		return ResponseEntity.ok(patientScore);	
	}
}