package BofA;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeResponse> create(@RequestBody EmployeeRequest employeeRequest) {
        employeeRepository.save(new Employee(null, employeeRequest.getName(), employeeRequest.getEmail()));
        EmployeeResponse response = new EmployeeResponse("201", "Employee created successfully");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/getByName")
    public ResponseEntity<EmployeeResponse> getByName(@RequestParam String name) {
        Employee employee = employeeRepository.findByName(name);
        if (employee == null) {
            EmployeeResponse response = new EmployeeResponse("404", "Employee not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(response);
        }
        EmployeeResponse response = new EmployeeResponse("200", employee.toString());
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/getByEmail")
    public ResponseEntity<EmployeeResponse> getByEmail(@RequestParam String email) {
        Employee employee = employeeRepository.findByEmail(email);
        if (employee == null) {
            EmployeeResponse response = new EmployeeResponse("404", "Employee not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(response);
        }
        EmployeeResponse response = new EmployeeResponse("200", employee.toString());
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }


    @PutMapping("/update")
    public ResponseEntity<EmployeeResponse> update(@RequestBody EmployeeRequest employeeRequest) {
        Employee employee = employeeRepository.findByName(employeeRequest.getName());
        if (employee == null) {
            EmployeeResponse response = new EmployeeResponse("404", "Employee not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(response);
        }
        employee.setEmail(employeeRequest.getEmail());
        employeeRepository.save(employee);
        EmployeeResponse response = new EmployeeResponse("200", "Employee updated successfully");
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<EmployeeResponse> delete(@RequestParam String name) {
        Employee employee = employeeRepository.findByName(name);
        EmployeeResponse response = null;
        if (employee == null) {
            response = new EmployeeResponse("404", "Employee not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(response);
        }
        employeeRepository.delete(employee);
        response = new EmployeeResponse("200", "Employee deleted successfully");
        return ResponseEntity.status(HttpStatus.OK)
                    .body(response);

    }


}
