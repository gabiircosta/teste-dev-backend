package projectOli.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import projectOli.model.request.HealthProblemRequest;
import projectOli.model.response.HealthProblemResponse;
import projectOli.persistence.entity.HealthProblem;
import projectOli.persistence.repository.HealthProblemRepository;
import projectOli.service.mapper.Mapper;

import java.util.Optional;

@Service
public class HealthProblemServiceImpl implements HealthProblemService {

	private static final Logger LOGGER = LoggerFactory.getLogger(HealthProblemService.class);

	@Autowired
	private HealthProblemRepository healthProblemRepository;
	
	@Autowired
	private Mapper<HealthProblemRequest, HealthProblem> requestProblemMapper;
	
	@Autowired
	private Mapper<HealthProblem, HealthProblemResponse> responseProblemMapper;
	
	@Override
	public HealthProblemResponse post(HealthProblemRequest healthProblemRequest) {
		LOGGER.info("Creating a Health Problem register");
		Assert.notNull(healthProblemRequest, "Bad Request");
		HealthProblem healthProblem = this.requestProblemMapper.map(healthProblemRequest);
		return healthProblemRepository.saveAndFlush(healthProblem).map((HealthProblem input) -> this.responseProblemMapper.map(input));
	}
	
	@Override
	public Page<HealthProblemResponse> getAll(Pageable pageable) {
		LOGGER.info("Searching all Health Problems");
		Assert.notNull(pageable, "Invalid Page");
		return healthProblemRepository.findAll(pageable).map(healthProblem ->this.responseProblemMapper.map(healthProblem));
	}

	@Override
	public Optional<HealthProblemResponse> update(Long id, HealthProblemRequest healthProblemRequest) {
		LOGGER.info("Updating datas");
		Assert.notNull(id, "Invalid id");
		
		HealthProblem healthProblemUpdate = this.requestProblemMapper.map(healthProblemRequest);

		return healthProblemRepository.findById(id)
				.map(healthProblem -> {
					healthProblem.setDeseaseDegree(healthProblemUpdate.getDeseaseDegree());
					healthProblem.setName(healthProblemUpdate.getName());
					
					return this.responseProblemMapper.map(healthProblemRepository.saveAndFlush(healthProblem));
				});
	}

		
}
