package pl.spring.demo.service;

import pl.spring.demo.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    EmployeeEntity saveEmployee(EmployeeEntity employee);
    void upadateLastNameByPesel(String lastName, String pesel);
	EmployeeEntity findEmployeeByPesel(String pesel);
        
}
