/**
 * 
 */
package pl.spring.demo.dao.impl;

import java.util.List;



import pl.spring.demo.dao.EmployeeDao;
import pl.spring.demo.entity.EmployeeEntity;

/**
 * @author HSIENKIE
 *
 */
public class EmployeeDaoImpl extends AbstractDao<EmployeeEntity, Long> implements EmployeeDao {
	
	@Override
	public List<EmployeeEntity> findEmployeesByFirstName(String firstName) {
		return entityManager.createQuery("from EmployeeEntity employee where upper(employee.firstName) like concat(upper(:firstName), '%')", EmployeeEntity.class)
				.setParameter("firstName", firstName).getResultList();

	}

	@Override
	public EmployeeEntity findEmployeesByPesel(String pesel) {
		return entityManager.createQuery("from EmployeeEntity employee where employee.pesel = :pesel", EmployeeEntity.class)
				.setParameter("pesel", pesel).getSingleResult();
	}

}