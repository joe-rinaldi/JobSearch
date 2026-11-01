package BofA;

import jakarta.persistence.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  //not needed but considered good practice
public interface KeyValueRepository extends JpaRepository<KeyValueEntity, String> {
    public KeyValueEntity findByKeyName(String keyName);
    public KeyValueEntity findByKeyValue(String keyValue);
}