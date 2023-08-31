package io.nology.employeecreator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeecreatorApplication {

	public static void main(String[] args) {
		EnvLoader.load();
		SpringApplication.run(EmployeecreatorApplication.class, args);
	}

}
