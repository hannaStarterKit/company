package pl.spring.demo.service;

/**
 * @author HSIENKIE
 *
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.EmployeeEntity;

import static org.junit.Assert.*;

import java.time.LocalDate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class EmployeeServiceValidationTest {

	@Autowired
	private EmployeeService employeeService;

	private EmployeeEntity testEmployee;

	@Test
	public void testShouldNotSaveEmployee() {
		// given
		final String lastName = null;
		testEmployee = new EmployeeEntity(null, "Jan", lastName, "91080801115", null, LocalDate.of(1991, 8, 8));
		EmployeeEntity employeeEntitySaved = null;
		try {
			// when
			employeeEntitySaved = employeeService.saveEmployee(testEmployee);
		} catch (IllegalArgumentException e) {
			// then
			assertNull(employeeEntitySaved);
			assertEquals("Last name cannot be null", e.getMessage());
		}
	}

}
