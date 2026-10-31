package BofA;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(EmployeeRepository repository) {
        return args -> {
            repository.save(new Employee(null, "John", "john@example.com"));
            repository.save(new Employee(null, "Mary", "mary@example.com"));
            repository.save(new Employee(null, "Bob", "bob@example.com"));

            repository.findAll()
                    .forEach(System.out::println);
        };
    }
}