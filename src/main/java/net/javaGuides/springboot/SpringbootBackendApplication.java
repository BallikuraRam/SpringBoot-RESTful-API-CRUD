package net.javaGuides.springboot;

import net.javaGuides.springboot.model.Employee;
import net.javaGuides.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository ;

	@Override
	public void run(String... args) throws Exception {

		Employee employee = new Employee();
		employee.setFirstName("lovely" );
		employee.setLastName("ram");
		employee.setEmailId("lovely@gmail.com");

		Employee employee1 = new Employee();
		employee1.setFirstName("dear" );
		employee1.setLastName("SR");
		employee1.setEmailId("Sr@gmail.com");
	}
}
