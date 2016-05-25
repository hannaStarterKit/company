/**
 * 
 */
package pl.spring.demo.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.dao.EmployeeDao;
import pl.spring.demo.dao.ProjectDao;
import pl.spring.demo.dao.ProjectPropertyDao;
import pl.spring.demo.entity.EmployeeEntity;
import pl.spring.demo.entity.ProjectEntity;
import pl.spring.demo.entity.ProjectPropertyEntity;
import pl.spring.demo.repository.ProjectPropertyRepository;
import pl.spring.demo.service.ProjectPropertyService;

/**
 * @author HSIENKIE
 *
 */
@Service
@Transactional(readOnly = true)
public class ProjectPropertyServiceImpl implements ProjectPropertyService {

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private ProjectPropertyDao projectPropertyDao;

	@Autowired
	private ProjectPropertyRepository projectPropertyRepository;

	@Override
	@Transactional(readOnly = false)
	@Modifying
	public ProjectEntity saveProject(ProjectEntity project) {
		return projectDao.save(project);
	}

	@Override
	public EmployeeEntity findEmployeeByPesel(String pesel) {
		return employeeDao.findEmployeesByPesel(pesel);
	}

	@Override
	public ProjectEntity findProjectByName(String projectName) {
		return projectDao.findProjectByName(projectName);
	}

	@Override
	public ProjectPropertyEntity saveProjectProperty(ProjectPropertyEntity projectPropertyEntity) {
		return projectPropertyDao.save(projectPropertyEntity);
	}

	@Override
	public void deleteProjectPropertyById(Long projectPropertyEntityIdToRemove) {
		projectPropertyDao.delete(projectPropertyEntityIdToRemove);

	}

	@Override
	public ProjectPropertyEntity findProjectPropertyByPeselProjectNameStartDate(String projectName, String pesel,
			Timestamp startDate) {
		return projectPropertyRepository.findProjectPropertyByPeselProjectNameStartDate(projectName, pesel, startDate);
	}

	@Override
	public ProjectPropertyEntity updateEndDate(String projectName, String pesel, Timestamp startDate,
			Timestamp endDate) {
		ProjectPropertyEntity projectPropertyEntity = this.findProjectPropertyByPeselProjectNameStartDate(projectName,
				pesel, startDate);
		//wyjatek
		projectPropertyEntity.setEndDate(endDate);
		return projectPropertyRepository.save(projectPropertyEntity);
	}

}
