package io.nology.employeecreator.employees;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee create(CreateEmployeeDTO data) {
		System.out.println(" -- service is running.... --- ");
		
		String firstName = data.getFirstName();
		String middleName = data.getMiddleName();
		String lastName = data.getLastName();
		String email = data.getEmail();
		Long mobile = data.getMobile();
		String address = data.getAddress();
		String contractType = data.getContractType();
		String startDate = data.getStartDate();
		String finishDate = data.getFinishDate();
		Boolean isFullTime = data.getIsFullTime();
		Integer hoursPerWeek = data.getHoursPerWeek();
			
		Employee newEmployee = new Employee(
				firstName,
				lastName,
				email,
				mobile,
				address,
				contractType,
				startDate,
				isFullTime,
				hoursPerWeek,
				middleName,
				finishDate
				);
		Employee createdEmployee = this.employeeRepository.save(newEmployee);
		return createdEmployee;
	}
	
	
	public List<Employee> findAll() {
		return this.employeeRepository.findAll();
	}
}
