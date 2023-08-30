package io.nology.employeecreator.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(
  properties = "test.base-url=http://localhost:8080",
  webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EmployeeControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void getAllReturnsAllEmployees() {
		ResponseEntity<String> response = restTemplate.getForEntity("/employees", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
}
