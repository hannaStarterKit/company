package pl.spring.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.EmployeeEntity;

import java.sql.Date;


import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testShouldSaveEmployee() {
        // given
        EmployeeEntity employee = new EmployeeEntity(null, "Jan", "Kowalski", "91080801114", new Date(91, 7, 8));
        // when
        EmployeeEntity employeeEntity = employeeService.saveEmployee(employee);
        // then
        assertNotNull(employeeEntity);
        assertEquals("Jan", employeeEntity.getFirstName());
    }
    
    @Test
    public void testShouldUpdateEmployeeLastNameByPesel() {
    	// given
    	final String pesel = "91080801113";
    	final String newLastName = "Bąk";
    	// when
    	employeeService.upadateLastNameByPesel(newLastName, pesel);
    	EmployeeEntity employeeEntity = employeeService.findEmployeeByPesel(pesel);
    	// then
    	assertNotNull(employeeEntity);
    	assertEquals("Bąk", employeeEntity.getLastName());
    }
    

}
