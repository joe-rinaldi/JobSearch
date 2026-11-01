package BofA;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Employee findByName(String name);
    public Employee findByEmail(String email);

    //below for demonstration purposes only, not recommended for production code
    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    public Employee findByEmail2(String email);
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    public Employee findByEmail3(@Param("email") String email);
    @Query(value="SELECT * FROM Employee e WHERE e.email = :email", nativeQuery = true)
    public Employee findByEmail4(@Param("email") String email);

    @Transactional
    @Modifying
    @Query("UPDATE Employee e SET e.email = :email WHERE e.id = :id")
    int updateEmployeeEmailById(@Param("id") Long id, @Param("email") String email);

    @Transactional
    @Modifying
    @Query("DELETE FROM Employee e WHERE e.id = :id")
    int deleteEmployeeById(@Param("id") Long id);
}
