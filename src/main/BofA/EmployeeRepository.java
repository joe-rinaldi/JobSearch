package BofA;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Employee findByName(String name);
    public Employee findByEmail(String email);
}
