package pl.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.entity.ProjectPropertyEntity;

import java.sql.Timestamp;
import java.util.List;

public interface ProjectPropertyRepository extends JpaRepository<ProjectPropertyEntity, Long> {

	@Query("select pp from ProjectPropertyEntity pp JOIN pp.employee e JOIN pp.project p where e.id = :employeeId and p.id = :projectId and pp.startDate = :startDate")
	public ProjectPropertyEntity findProjectPropertyByProjectIdEmployeeIdStartDate(
			@Param("startDate") Timestamp startDate, @Param("projectId") Long projectId,
			@Param("employeeId") Long employeeId);

	@Query("select pp from ProjectPropertyEntity pp JOIN pp.employee e JOIN pp.project p where e.pesel = :pesel and p.name = :projectName and pp.startDate = :startDate")
	public ProjectPropertyEntity findProjectPropertyByPeselProjectNameStartDate(
			@Param("projectName") String projectName, @Param("pesel") String pesel,
			@Param("startDate") Timestamp startDate);

}
