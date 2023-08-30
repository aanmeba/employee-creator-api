package io.nology.employeecreator.employee;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
		properties = "test.base-url=http://localhost:8080",
		webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EmployeeControllerTest {

	
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void getAllReturnsAllEmployees() {
		System.out.println("--- Running..... ---");
	}
}
