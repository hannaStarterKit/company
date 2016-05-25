/**
 * 
 */
package pl.spring.demo.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

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
public class ProjectPropertyServiceTest {

	@Autowired
	private ProjectPropertyService projectPropertyService;

	// test powinien sprawdzac tylko jedna rzecz, wiec nie powinnam najpierw
	// tworzyc projectu a pozniej go zapisywac tylko raz stworzyc raz zapisac,
	// ale zeby spawdzic zapisywanie muszę najpierw stworzyyc
	@Test
	public void testShouldCreateNewProjectAndSaveIt() {
		// given
		final String type = "inner";
		final String name = "XX";
		ProjectEntity newProjectEntity = new ProjectEntity(null, name, type);

		// when
		ProjectEntity savedProjectEntity = projectPropertyService.saveProject(newProjectEntity);

		// then
		assertNotNull(savedProjectEntity);
		assertEquals(type, savedProjectEntity.getType());
		assertEquals(name, savedProjectEntity.getName());
	}

	@Test
	public void testShouldAddEmployeeToProject() {
		// given
		final String projectName = "XX";
		final String pesel = "91080801111";
		final String role = "PL";
		final BigDecimal salary = new BigDecimal(10.0);
		final Timestamp startDate = Timestamp.valueOf("2015-09-09 00:00:00.0");
		EmployeeEntity employeeEntity = projectPropertyService.findEmployeeByPesel(pesel);
		ProjectEntity projectEntity = projectPropertyService.findProjectByName(projectName);

		// when
		ProjectPropertyEntity projectPropertyEntity = new ProjectPropertyEntity(null, role, salary, startDate, null,
				employeeEntity, projectEntity);
		ProjectPropertyEntity projectPropertyEntitySaved = projectPropertyService
				.saveProjectProperty(projectPropertyEntity);

		// then
		assertNotNull(projectPropertyEntitySaved);
		final long projectPropertyEntityIdToRemove = projectPropertyEntitySaved.getId();
		projectPropertyService.deleteProjectPropertyById(projectPropertyEntityIdToRemove);
	}

	@Test
	public void testShouldRemoveEmployeeFromProject() {
		// given
		final String projectName = "Breakfast";
		final String pesel = "92012305124";
		final Timestamp startDate = Timestamp.valueOf("2007-07-08 00:00:00.0");
		final Timestamp endDate = Timestamp.valueOf("2015-09-09 00:00:00.0");


		// when
		
		ProjectPropertyEntity projectPropertyEntityUpdated = projectPropertyService.updateEndDate(projectName, pesel ,startDate, endDate);

		// given
		assertNotNull(projectPropertyEntityUpdated);
		assertEquals(endDate, projectPropertyEntityUpdated.getEndDate());

		projectPropertyService.updateEndDate(projectName, pesel ,startDate, null);
	}

}
