package io.nology.employeecreator.employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private final List<String> validContractTypes = Arrays.asList("permanent", "contract"); 
	private boolean isValidContractType(String type) {
		return validContractTypes.contains(type.toLowerCase());
	}
	
	public Employee create(CreateEmployeeDTO data) {

//		String firstName = data.getFirstName();
//		String middleName = data.getMiddleName();
//		String lastName = data.getLastName();
//		String email = data.getEmail();
//		String mobile = data.getMobile();
//		String address = data.getAddress();
		String contractType = data.getContractType();
//		String startDate = data.getStartDate();
//		String finishDate = data.getFinishDate();
//		Boolean isFullTime = data.getIsFullTime();
//		Integer hoursPerWeek = data.getHoursPerWeek();

//		Employee newEmployee = new Employee(
//				firstName,
//				lastName,
//				email,
//				mobile,
//				address,
//				contractType,
//				startDate,
//				isFullTime,
//				hoursPerWeek,
//				middleName,
//				finishDate
//				);
		
		boolean validContractType = this.isValidContractType(contractType);
		if (!validContractType) {
			throw new IllegalArgumentException("Please enter a valid contract type");
		}
		
		Employee newEmployee = modelMapper.map(data, Employee.class);
		Employee createdEmployee = this.employeeRepository.save(newEmployee);
		return createdEmployee;
	}
	
	
	public List<Employee> findAll() {
		return this.employeeRepository.findAll();
	}
	
	public Optional<Employee> findById(Long id) {
		Optional<Employee> maybeEmployee = this.employeeRepository.findById(id);
		return maybeEmployee;
	}
	
	public boolean deleteById(Long id) {
		Optional<Employee> maybeEmployee = this.findById(id);
		
		if (maybeEmployee.isEmpty()) return false;
		
		this.employeeRepository.delete(maybeEmployee.get());
		return true;
	}
	
	public Optional<Employee> updateById(Long id, UpdateEmployeeDTO data) {
		
		Optional<Employee> maybeEmployee = this.findById(id);
		
		if (maybeEmployee.isPresent()) {
			Employee existingEmployee = maybeEmployee.get();
			
			modelMapper.map(data, existingEmployee);
			return Optional.of(this.employeeRepository.save(existingEmployee));
		}
		return maybeEmployee;		
	}
}
