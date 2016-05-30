package pl.spring.demo.service;

import java.sql.Timestamp;


import pl.spring.demo.entity.EmployeeEntity;
import pl.spring.demo.entity.ProjectEntity;
import pl.spring.demo.entity.ProjectPropertyEntity;

public interface ProjectPropertyService {

	ProjectEntity saveProject(ProjectEntity project);

	EmployeeEntity findEmployeeByPesel(String pesel);

	ProjectEntity findProjectByName(String projectName);

	ProjectPropertyEntity saveProjectProperty(ProjectPropertyEntity projectPropertyEntity);

	void deleteProjectProperty(ProjectPropertyEntity projectPropertyEntity);

	ProjectPropertyEntity findProjectPropertyByPeselProjectNameStartDate(String projectName, String pesel,
			Timestamp startDate);

	ProjectPropertyEntity updateEndDate(String projectName, String pesel, Timestamp startDate, Timestamp endDate);

	void deleteProject(ProjectEntity projectEntity);

}
