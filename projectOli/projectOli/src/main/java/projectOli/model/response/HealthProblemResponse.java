package projectOli.model.response;

public class HealthProblemResponse {
	
	private Long id;
	private String name;
	private int deseaseDegree;
//	private Patient patient;
	
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
	public int getDeseaseDegree() {
		return deseaseDegree;
	}
	public void setDeseaseDegree(int degree) {
		this.deseaseDegree = degree;
	}

}