package pl.spring.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.entity.EmployeeEntity;
import pl.spring.demo.repository.EmployeeRepository;
import pl.spring.demo.service.EmployeeService;


@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


	@Override
	@Transactional(readOnly = false)
	public EmployeeEntity saveEmployee(EmployeeEntity employee) {
		return employeeRepository.save(employee);
	}


	@Override
	@Transactional(readOnly = false)
	public void upadateLastNameByPesel(String lastName, String pesel) {
		employeeRepository.updateLastNameByPesel(lastName, pesel);
	}


	@Override
	public EmployeeEntity findEmployeeByPesel(String pesel) {
		return employeeRepository.findEmployeeByPesel(pesel);
	}
}
