package app;

import BofA.Employee;
import BofA.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"app", "BofA"})
@EntityScan(basePackageClasses = Employee.class)
@EnableJpaRepositories(basePackageClasses = EmployeeRepository.class)
public class JobSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobSearchApplication.class, args);
    }
}
