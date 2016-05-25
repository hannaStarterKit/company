package pl.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Query("select employee from EmployeeEntity employee where upper(employee.firstName) like concat(upper(:firstName), '%')")
    public List<EmployeeEntity> findEmployeeByFirstName(@Param("firstName") String firstName);
    
    @Query("select employee from EmployeeEntity employee where upper(employee.lastName) like concat(upper(:lastName), '%')")
    public List<EmployeeEntity> findEmployeeByLastName(@Param("lastName") String lastName);
    
    @Query("select employee from EmployeeEntity employee where employee.pesel = :pesel")
    public EmployeeEntity findEmployeeByPesel(@Param("pesel") String pesel);

    @Query("select employee from EmployeeEntity employee JOIN employee.department department where upper(department.name) like concat('%', upper(:name), '%')")
    public List<EmployeeEntity> findEmployeeByDepartmentName(@Param("name") String name);

    @Query("select employee from EmployeeEntity employee JOIN employee.projectProperty pp where pp.role like :role")
	public List<EmployeeEntity> findEmployeByRole(@Param("role") String role);
    
    @Modifying
    @Transactional(readOnly = false)
    @Query("update EmployeeEntity employee set employee.lastName = :lastName where employee.pesel = :pesel")
	public void updateLastNameByPesel(@Param("lastName") String lastName, @Param("pesel") String pesel);
}
