package BofA;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(EmployeeRepository employeeRepository, KeyValueRepository keyValueRepository) {
        return args -> {
            employeeRepository.save(new Employee(null, "John", "john@example.com"));
            employeeRepository.save(new Employee(null, "Mary", "mary@example.com"));
            employeeRepository.save(new Employee(null, "Bob", "bob@example.com"));

            employeeRepository.findAll()
                    .forEach(System.out::println);

            keyValueRepository.save(new KeyValueEntity(null, "key1", "value1"));    ;
            keyValueRepository.save(new KeyValueEntity(null, "key2", "value2"));

            keyValueRepository.findAll()
                    .forEach(System.out::println);

        };
    }
}