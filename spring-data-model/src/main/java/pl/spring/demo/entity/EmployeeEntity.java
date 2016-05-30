/**
 * 
 */
package pl.spring.demo.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotNull;

import javax.persistence.*;

/**
 * @author HSIENKIE
 *
 */
@Entity
@Table(name = "EMPLOYEES")
public class EmployeeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6916220891793920309L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message="Last name cannot be null")
	@Column(nullable = false, length = 30, name = "last_name")
	private String lastName;
	@Column(nullable = false, length = 15, name = "first_name")
	private String firstName;
	@Column(nullable = false, length = 11, unique = true)
	private String pesel;
	@Column(nullable = false, name = "date_of_birth")
	private Date dateOfBirth;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<ProjectPropertyEntity> projectProperty = new HashSet<>();

	// @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// @JoinTable(name = "BOOK_AUTHOR", joinColumns = {
	// @JoinColumn(name = "BOOK_ID", nullable = false, updatable = false,
	// referencedColumnName = "id") }, inverseJoinColumns = {
	// @JoinColumn(name = "AUTHOR_ID", nullable = false, updatable = false,
	// referencedColumnName = "id") })
	// private Set<AuthorEntity> authors = new HashSet<>();
	@ManyToOne
	@JoinColumn(name = "department_id", nullable = true)
	private DepartmentEntity department;

	// for hibernate
	protected EmployeeEntity() {
	}

	public EmployeeEntity(Long id, String firstName, String lastName, String pesel, DepartmentEntity department,
			LocalDate dateOfBirth) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = Date.valueOf(dateOfBirth);
		this.pesel = pesel;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth.toLocalDate();
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = Date.valueOf(dateOfBirth);
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}
}
