package projectOli.service.mapper;

import org.springframework.stereotype.Component;
import projectOli.model.response.HealthProblemResponse;
import projectOli.persistence.entity.HealthProblem;

@Component
public class HealthProblemResponseMapper implements Mapper<HealthProblem, HealthProblemResponse>{

	@Override
	public HealthProblemResponse map(HealthProblem input) {
		
		if (input == null) {
			return null;
		}
		
		HealthProblemResponse healthProblemResponse = new HealthProblemResponse();
		
		healthProblemResponse.setId(input.getId());
		healthProblemResponse.setName(input.getName());
		healthProblemResponse.setDeseaseDegree(input.getDeseaseDegree());
		
		return healthProblemResponse;
	}

}
