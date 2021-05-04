package projectOli.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;


@Entity
@Table (name = "patient")
public class Patient {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long id;
	
	@Column (name = "name", nullable = false)
	@Size (min = 2, max = 100, message = "Warning: Data out of needed params - character amount: min-2, max-100")
	private String name;
	
	@Column (name = "birth_date", nullable = false)
	@Size (min = 8, message = "Warning: Data out of needed params - character amount: min-8")
	private String birthDate;
	
	@Column (name = "gender", nullable = false)
	@Size (min = 2, max = 50, message = "Warning: Data out of needed params - character amount: min-2, max-50")
	private String gender;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate = new Date();
	
	@Column (name = "update_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate = new java.sql.Date(System.currentTimeMillis());
		
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
		name="patient_has_healthProblem",
		joinColumns=  @JoinColumn(name="patient_id"),
		inverseJoinColumns= @JoinColumn(name="healthProblems_id")
			)
	@JsonIgnoreProperties("patient")
	private List<HealthProblem> healthProblem = new ArrayList();
	
	public<R> R map(Function<Patient, R> func) {
		return func.apply(this);
	}
	

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


	public List<HealthProblem> getHealthProblem() {
		return healthProblem;
	}


	public void setHealthProblem(List<HealthProblem> healthProblem) {
		this.healthProblem = healthProblem;
	}
	
}