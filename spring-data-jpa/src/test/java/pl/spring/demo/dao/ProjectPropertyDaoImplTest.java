package pl.spring.demo.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.entity.ProjectPropertyEntity;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonDaoTest-context.xml")
public class ProjectPropertyDaoImplTest {

	@Autowired
	private ProjectPropertyDao projectPropertyDao;

	@Test
	public void testShouldFindProjectPropertyById() {
		// given
		final long projectPropertyId = 3;
		// when
		ProjectPropertyEntity projectPropertyEntity = projectPropertyDao.findOne(projectPropertyId);
		// then
		assertNotNull(projectPropertyEntity);
		final Long employeeIdExpected = 2L;
		assertEquals(employeeIdExpected, projectPropertyEntity.getEmployee().getId());
		final Long projectIdExpected = 7L;
		assertEquals(projectIdExpected, projectPropertyEntity.getProject().getId());
	}


}
