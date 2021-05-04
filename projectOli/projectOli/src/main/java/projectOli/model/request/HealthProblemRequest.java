package projectOli.model.request;

import javax.validation.constraints.NotBlank;

public class HealthProblemRequest {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private int deseaseDegree;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeseaseDegree() {
		return deseaseDegree;
	}

	public void setDeseaseDegree(int degree) {
		this.deseaseDegree = degree;
	}

}