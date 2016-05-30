/**
 * 
 */
package pl.spring.demo.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.EmployeeEntity;
import pl.spring.demo.entity.ProjectEntity;
import pl.spring.demo.entity.ProjectPropertyEntity;

/**
 * @author HSIENKIE
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class ProjectPropertyServiceEmployeeAddRemoveTest {

	@Autowired
	private ProjectPropertyService projectPropertyService;

	private final String projectName = "Very important";
	private final String pesel = "91080801111";
	private final String role = "PL";
	private final BigDecimal salary = new BigDecimal(10.0);
	private final Timestamp startDate = Timestamp.valueOf("2015-09-09 00:00:00.0");



	@Before
	public void saveProjectProperty() {
//		employeeEntity = projectPropertyService.findEmployeeByPesel(pesel);
//		projectEntity = projectPropertyService.findProjectByName(projectName);

//		projectPropertyEntity = new ProjectPropertyEntity(null, role, salary, startDate, null, employeeEntity,
//				projectEntity);
	}

	@After
	public void removeProjectAndProjectProperty() {
		
	}

	@Test
	public void testShouldAddEmployeeToProject() {
		// given
		EmployeeEntity employeeEntity = projectPropertyService.findEmployeeByPesel(pesel);
		ProjectEntity projectEntity = projectPropertyService.findProjectByName(projectName);
		ProjectPropertyEntity projectPropertyEntity = new ProjectPropertyEntity(null, role, salary, startDate, null, employeeEntity,
		projectEntity);
		// when
		ProjectPropertyEntity projectPropertyEntitySaved = projectPropertyService
				.saveProjectProperty(projectPropertyEntity);

		// then
		assertNotNull(projectPropertyEntitySaved);
		assertEquals(startDate, projectPropertyEntitySaved.getStartDate());
		assertEquals(pesel, projectPropertyEntitySaved.getEmployee().getPesel());
		assertEquals(projectName, projectPropertyEntitySaved.getProject().getName());
		projectPropertyService.deleteProjectProperty(projectPropertyEntitySaved);
	}

	@Test
	@Ignore
	public void testShouldRemoveEmployeeFromProject() {
		// given
		EmployeeEntity employeeEntity = projectPropertyService.findEmployeeByPesel(pesel);
		ProjectEntity projectEntity = projectPropertyService.findProjectByName(projectName);
		final Timestamp endDate = Timestamp.valueOf("2015-09-09 00:00:00.0");
		ProjectPropertyEntity projectPropertyEntity = new ProjectPropertyEntity(null, role, salary, startDate, null, employeeEntity,
		projectEntity);
		ProjectPropertyEntity projectPropertyEntitySaved = projectPropertyService
				.saveProjectProperty(projectPropertyEntity);

		// when
		ProjectPropertyEntity projectPropertyEntityUpdated = projectPropertyService.updateEndDate(projectName, pesel,
				startDate, endDate);

		// given
		assertNull(projectPropertyEntitySaved.getEndDate());
		assertNotNull(projectPropertyEntityUpdated);
		//assertEquals(endDate, projectPropertyEntity.getEndDate());
		projectPropertyService.deleteProjectProperty(projectPropertyEntityUpdated);
	}

}
