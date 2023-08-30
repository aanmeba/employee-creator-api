package io.nology.employeecreator.employee;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeControllerTest {

	
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void getAllReturnsAllEmployees() {
		System.out.println("--- Running..... ---");
	}
}
