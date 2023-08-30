package io.nology.employeecreator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
class EmployeecreatorApplicationTests {

	@Test
	void contextLoads(ApplicationContext context) {
		assertThat(context).isNotNull();
	}
	
	@Test
	void hasIndieAuthControllerConfigured(ApplicationContext context) {
		assertThat(context.getBean("accessTokenVerifier")).isNotNull();
	}

}
