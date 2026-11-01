package BofA;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class KeyValueDto {
    private Long id;
    private String keyName;
    private String keyValue;
}

