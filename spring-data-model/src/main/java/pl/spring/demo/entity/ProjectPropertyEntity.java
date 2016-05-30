package pl.spring.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * The persistent class for the project_property database table.
 * 
 */
@Entity
@Table(name = "project_property")
@NamedQuery(name = "ProjectPropertyEntity.findAll", query = "SELECT p FROM ProjectPropertyEntity p")
public class ProjectPropertyEntity implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5718117240588088458L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "end_date")
	private Timestamp endDate;

	@Column(nullable = false, length = 1)
	private String role;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal salary;

	@Column(name = "start_date", nullable = false)
	private Timestamp startDate;

	// bi-directional many-to-one association
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private EmployeeEntity employee;

	// bi-directional many-to-one association
	@ManyToOne
	@JoinColumn(name = "project_id", nullable = false)
	private ProjectEntity project;

	public ProjectPropertyEntity(Long id, String role, BigDecimal salary, Timestamp startDate, Timestamp endDate,
			EmployeeEntity employee, ProjectEntity project) {
		this.id = id;
		this.role = role;
		this.salary = salary;
		this.startDate = startDate;
		this.endDate = endDate;
		this.project = project;
		this.employee = employee;
	}

	protected ProjectPropertyEntity() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public EmployeeEntity getEmployee() {
		return this.employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	public ProjectEntity getProject() {
		return this.project;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

}