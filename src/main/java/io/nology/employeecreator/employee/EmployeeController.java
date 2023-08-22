package io.nology.employeecreator.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.nology.employeecreator.exception.NotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody CreateEmployeeDTO data) {
		Employee createdEmployee = this.employeeService.create(data);
		return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> allEmployees = this.employeeService.findAll();
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> findById(@PathVariable Long id) {
		Optional<Employee> foundEmployee = this.employeeService.findById(id);
		if (foundEmployee.isEmpty()) {
			throw new NotFoundException("Not Found the Employee");
		}
		return new ResponseEntity<>(foundEmployee.get(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable Long id) {
		boolean deleted = this.employeeService.deleteById(id);
		
		if (!deleted) return "Oops!, not found";
		return "Deleted";
	}
}
