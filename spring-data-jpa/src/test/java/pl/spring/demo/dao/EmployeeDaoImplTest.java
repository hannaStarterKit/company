package pl.spring.demo.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.EmployeeEntity;
import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonDaoTest-context.xml")
public class EmployeeDaoImplTest {

    @Autowired
    private EmployeeDao employeeDao;
    
    @Test
    public void testShouldFindEmployeeById() {
        // given
        final long employeeId = 2;
        // when
        EmployeeEntity employeeEntity = employeeDao.findOne(employeeId);
        // then
        assertNotNull(employeeEntity);
        assertEquals("Barbara", employeeEntity.getFirstName());
    }


    
    @Test
    public void testShouldFindEmployeesByFirstName() {
    	// given
    	final String firstName = "bar";
    	// when
    	List<EmployeeEntity> employeesEntity = employeeDao.findEmployeesByFirstName(firstName);
    	// then
    	assertNotNull(employeesEntity);
    	assertFalse(employeesEntity.isEmpty());
    	assertEquals("Barbara", employeesEntity.get(0).getFirstName());
    }
    
}
