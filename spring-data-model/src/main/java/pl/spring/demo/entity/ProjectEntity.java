/**
 * 
 */
package pl.spring.demo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author HSIENKIE
 *
 */
@Entity
@Table(name = "PROJECTS")
public class ProjectEntity implements Serializable{
	//@SequenceGenerator(name="pracownik_id_generator", sequenceName="Pracownik_SEQ", allocationSize=1)//pracownik_seq jest zdefiniowane w bazce
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pracownik_id_generator")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 50, name = "project_name")
	private String name;
	@Column(nullable = false, length = 50, name = "project_type")
	private String type;
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<ProjectPropertyEntity> projectPropert = new HashSet<>();
	
	// for hibernate
	protected ProjectEntity() {
	}

	public ProjectEntity(Long id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
