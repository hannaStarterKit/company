package pl.spring.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.ProjectPropertyEntity;

import static org.junit.Assert.*;

import java.sql.Timestamp;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class ProjectPropertyRepositoryTest {

	@Autowired
	private ProjectPropertyRepository projectPropertyRepository;

	@Test
	public void testShouldFindProjectPropertyByEmployeeIdProjectIdStartDate() {
		// given
		final long employeeId = 2;
		final long projectId = 7;
		final Timestamp startDate = Timestamp.valueOf("2007-07-08 00:00:00.0");
		// when
		ProjectPropertyEntity projectPropertyEntity = projectPropertyRepository
				.findProjectPropertyByProjectIdEmployeeIdStartDate(startDate, projectId, employeeId);
		// then
		assertNotNull(projectPropertyEntity);
		final Long projectPropertyIdExpected = 3L;
		assertEquals(projectPropertyIdExpected, projectPropertyEntity.getId());
	}
}
