package projectOli.model.request;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class PatientRequest {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String birthDate;
	
	@NotBlank
	private String gender;
	
	@NotBlank
	private List<HealthProblemRequest> healthProblem;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public List<HealthProblemRequest> getHealthProblem() {
		return healthProblem;
	}
	
	public void setHealthProblem(List<HealthProblemRequest> healthProblem) {
		this.healthProblem = healthProblem;
	}

}