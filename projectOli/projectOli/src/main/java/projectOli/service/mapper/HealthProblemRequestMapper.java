package projectOli.service.mapper;

import org.springframework.stereotype.Component;
import projectOli.model.request.HealthProblemRequest;
import projectOli.persistence.entity.HealthProblem;

@Component
public class HealthProblemRequestMapper implements Mapper<HealthProblemRequest, HealthProblem>{

	@Override
	public HealthProblem map(HealthProblemRequest input) {
		if (input == null) {
			return null;
		}
		
		HealthProblem healthProblem = new HealthProblem ();
		healthProblem.setName(input.getName());
		healthProblem.setDeseaseDegree(input.getDeseaseDegree());

		return healthProblem;
	}	

}
