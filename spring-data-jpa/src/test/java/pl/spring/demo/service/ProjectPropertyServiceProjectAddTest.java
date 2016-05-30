/**
 * 
 */
package pl.spring.demo.service;

import static org.junit.Assert.*;



import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import pl.spring.demo.entity.ProjectEntity;


/**
 * @author HSIENKIE
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class ProjectPropertyServiceProjectAddTest {

	@Autowired
	private ProjectPropertyService projectPropertyService;

	private ProjectEntity newProjectEntity;
	
	@After
	public void removeProject(){
		projectPropertyService.deleteProject(newProjectEntity);
	}
	
	@Test
	public void testShouldCreateNewProjectAndSaveIt() {
		// given
		final String type = "inner";
		final String name = "mdhfcosn";
		newProjectEntity = new ProjectEntity(null, name, type);

		// when
		ProjectEntity savedProjectEntity = projectPropertyService.saveProject(newProjectEntity);

		// then
		assertNotNull(savedProjectEntity);
		assertEquals(type, savedProjectEntity.getType());
		assertEquals(name, savedProjectEntity.getName());
	}

}
