package projectOli.model.response;

import java.util.Date;
import java.util.List;

public class PatientResponse {

	private Long id;
	private String name;
	private String birthDate;
	private String gender;
	private Date creationDate = new Date();
	private Date updateDate = new java.sql.Date(System.currentTimeMillis());
	private List<HealthProblemResponse> healthProblem;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public List<HealthProblemResponse> getHealthProblem() {
		return healthProblem;
	}
	public void setHealthProblem(List<HealthProblemResponse> healthProblem) {
		this.healthProblem = healthProblem;
	}

}