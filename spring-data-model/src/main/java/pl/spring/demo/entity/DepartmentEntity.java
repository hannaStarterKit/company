/**
 * 
 */
package pl.spring.demo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * @author HSIENKIE
 *
 */

@Entity
@Table(name = "DEPARTMENTS")
public class DepartmentEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 50, name = "department_name")
	private String name;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<EmployeeEntity> employees= new HashSet<>();
	
	// for hibernate
	protected DepartmentEntity() {
	}

	public DepartmentEntity(Long id, String name) {
		this.id = id;
		this.name = name;
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

}
