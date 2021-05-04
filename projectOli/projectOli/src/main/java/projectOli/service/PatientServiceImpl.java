package projectOli.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import projectOli.model.request.PatientRequest;
import projectOli.model.response.PatientResponse;
import projectOli.persistence.entity.HealthProblem;
import projectOli.persistence.entity.Patient;
import projectOli.persistence.repository.PatientRepository;
import projectOli.service.mapper.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PatientService.class);
	
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private Mapper<PatientRequest, Patient> requestMapper;
	
	@Autowired
	private Mapper<Patient, PatientResponse> responseMapper;
	
	@Override
	public PatientResponse post(PatientRequest patientRequest) {
		LOGGER.info("Creating a patient register");
		Assert.notNull(patientRequest, "Bad Request");
		Patient patient = this.requestMapper.map(patientRequest);
		//patient.setCreationDate(null); preenche a data de criação aqui, só sera feito no momento da criaçao
		return patientRepository.saveAndFlush(patient).map((Patient input) -> this.responseMapper.map(input));
	}

	@Override
	public Page<PatientResponse> getAll(Pageable pageable) {
		LOGGER.info("Searching all patients");
		Assert.notNull(pageable, "Invalid Page");
		return patientRepository.findAll(pageable).map(patient ->this.responseMapper.map(patient));
	}

	@Override
	public Optional<PatientResponse> get(Long id) {
		LOGGER.info("Searching patient by id");
		Assert.notNull(id, "Invalid id");
		return patientRepository.findById(id).map(this.responseMapper::map);
	}

	@Override
	public Optional<PatientResponse> update(Long id, PatientRequest patientRequest) {
		LOGGER.info("Updating datas");
		Assert.notNull(id, "Invalid id");
		
		Patient patientUpdate = this.requestMapper.map(patientRequest);

		return patientRepository.findById(id)
				.map(patient -> {
					patient.setGender(patientUpdate.getGender());
					patient.setName(patientUpdate.getName());
					
					return this.responseMapper.map(patientRepository.saveAndFlush(patient));
				});
	}

	@Override
	public boolean delete(Long id) {
		LOGGER.info("Deleting data");
		Assert.notNull(id, "Invalid id");
		
		try {
			patientRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			LOGGER.warn("An error ocurred, when trying to delet id {}", id);
		}
		
		return false;
	}

	
	@Override
	public Map<String, Integer> getByRanking() {
		
		List<Patient> patients = patientRepository.findAll();		
		Map<String, Integer> patientScore= new HashMap<>();
		for(Patient patient : patients) {
			int finalScore = 0;
			for(HealthProblem healthProblem : patient.getHealthProblem()) {
				finalScore += healthProblem.getDeseaseDegree();
			}
			
			patientScore.put(patient.getName(), finalScore);
			
		}
		
		
		return patientScore;
	}

}
