package io.nology.employeecreator.employee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@Mock
	private EmployeeRepository employeeRepository;
	
	
	@InjectMocks
	private EmployeeService underTest;
	
	@Test
	void findAllShouldCallFindAll() {
		underTest.findAll();
		verify(employeeRepository).findAll();
	}
	
	@Test
	void itShouldCreateNewEmployee() {
		CreateEmployeeDTO employee = new CreateEmployeeDTO(
				"Ben", "Crown", "ben@test.com",
				"0410123123", "1 Australia ave", "contract",
				"2023-08-01", true, 40, "", ""
				);
		
		underTest.create(employee);
		
		ArgumentCaptor<Employee> employeeArgument =
				ArgumentCaptor.forClass(Employee.class);
		verify(employeeRepository).save(employeeArgument.capture());
		
		assertThat(employeeArgument.getValue().getFirstName()).isEqualTo(employee.getFirstName());
	}
	
	@Test
	void itShouldNotCreateNewEmployee() {
		CreateEmployeeDTO employee = new CreateEmployeeDTO(
				"Ben", "Crown", "ben@test.com",
				"0410123123", "1 Australia ave", "casual",
				"2023-08-01", true, 40, "", ""
				);
		
		assertThatThrownBy(() -> underTest.create(employee))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("Please enter a valid contract type");
		
		assertThat(employeeRepository.count()).isEqualTo(0);
	}
}
