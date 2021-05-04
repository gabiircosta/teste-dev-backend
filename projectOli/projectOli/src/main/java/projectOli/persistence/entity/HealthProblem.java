package projectOli.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.function.Function;

@Entity
@Table (name = "health_problem")
public class HealthProblem {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@Column (name = "name", nullable = false)
	@Size (min = 2, max = 100, message = "Warning: Data out of needed params - character amount: min-2, max-100")
	private String name;
	
	@Column (name = "desease_degree", nullable = false)
	private int deseaseDegree;
	
	public<R> R map(Function<HealthProblem, R> func) {
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

	public int getDeseaseDegree() {
		return deseaseDegree;
	}

	public void setDeseaseDegree(int degree) {
		this.deseaseDegree = degree;
	}
	
}