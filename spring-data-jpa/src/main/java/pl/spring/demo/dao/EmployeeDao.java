/**
 * 
 */
package pl.spring.demo.dao;

import java.util.List;


import pl.spring.demo.entity.EmployeeEntity;



/**
 * @author HSIENKIE
 *
 */
public interface EmployeeDao extends Dao<EmployeeEntity, Long> {
	


    List<EmployeeEntity> findEmployeesByFirstName(String firstName);

	EmployeeEntity findEmployeesByPesel(String pesel);
}
