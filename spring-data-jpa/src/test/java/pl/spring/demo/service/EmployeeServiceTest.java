package pl.spring.demo.service;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.EmployeeEntity;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;

	private EmployeeEntity testEmployee;

	@After
	public void removeTestEmployee() {
		employeeService.deleteEmployee(testEmployee);
	}

	@Test
	public void testShouldSaveEmployee() {
		// given
		testEmployee = new EmployeeEntity(null, "Jan", "Kowalski", "91080801115", null, LocalDate.of(1991, 8, 8));
		// when
		EmployeeEntity employeeEntitySaved = employeeService.saveEmployee(testEmployee);
		final long testId = employeeEntitySaved.getId();
		// then
		assertNotNull(employeeEntitySaved);
		assertEquals("Jan", employeeService.findOne(testId).getFirstName());
	}
	
	@Test
	public void testShouldUpdateEmployeeLastNameByPesel() {
		// given
		final String pesel = "00000000000";
		final String newLastName = "Bąk";
		testEmployee = new EmployeeEntity(null, "Jan", "Kowalski", pesel, null, LocalDate.of(1991, 8, 8));
		employeeService.saveEmployee(testEmployee);
		// when
		employeeService.upadateLastNameByPesel(newLastName, pesel);
		EmployeeEntity employeeEntityUpdated = employeeService.findEmployeeByPesel(pesel);
		// then
		assertNotNull(employeeEntityUpdated);
		assertEquals("Bąk", employeeEntityUpdated.getLastName());
	}

}
