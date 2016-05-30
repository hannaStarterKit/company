package pl.spring.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.EmployeeEntity;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testShouldFindEmployeeById() {
        // given
        final long employeeId = 1;
        // when
        EmployeeEntity employeeEntity = employeeRepository.findOne(employeeId);
        // then
        assertNotNull(employeeEntity);
        assertEquals("Jan", employeeEntity.getFirstName());
    }

    @Test
    public void testShouldFindEmployeesByFirstName() {
        // given
        final String firstName = "pankr";
        // when
        List<EmployeeEntity> employeesEntity = employeeRepository.findEmployeeByFirstName(firstName);
        // then
        assertNotNull(employeesEntity);
        assertFalse(employeesEntity.isEmpty());
        assertEquals("Pankracy", employeesEntity.get(0).getFirstName());
    }
    
    @Test
    public void testShouldFindEmployeeByDepartmentName() {
    	// given
    	final String name = "reception";
    	// when
    	List<EmployeeEntity> employeesEntity = employeeRepository.findEmployeeByDepartmentName(name);
    	// then
    	assertNotNull(employeesEntity);
    	assertFalse(employeesEntity.isEmpty());
    	assertEquals("Barbara", employeesEntity.get(0).getFirstName());
    }
    
    @Test
    public void testShouldFindEmployeeByRole() {
    	// given
    	final String role = "PL";
    	// when
    	List<EmployeeEntity> employeesEntity = employeeRepository.findEmployeByRole(role);
    	// then
    	assertNotNull(employeesEntity);
    	assertFalse(employeesEntity.isEmpty());
    	assertEquals("Pankracy", employeesEntity.get(0).getFirstName());
    }
    
    @Test
    public void testUpdateLastNameByPesel() {
    	// given
    	final String pesel = "91080801113";
    	final String newLastName = "Nowak";
    	// when
    	employeeRepository.updateLastNameByPesel(newLastName, pesel);
    	EmployeeEntity employeeEntity = employeeRepository.findEmployeeByPesel(pesel);
    	// then
    	assertNotNull(employeeEntity);
    	assertEquals("Nowak", employeeEntity.getLastName());
    }
}
