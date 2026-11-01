package BofA;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class KeyValueService {
    final private KeyValueRepository keyValueRepository;

    public KeyValueService(KeyValueRepository keyValueRepository) {
        this.keyValueRepository = keyValueRepository;
    }


    public KeyValueDto getKeyValue(String value) {
        KeyValueEntity keyValueEntity = keyValueRepository.findByKeyValue(value);

        KeyValueDto keyValueDto = new KeyValueDto(null,"key", "not found");
        if (keyValueEntity != null && !StringUtils.isEmpty(keyValueEntity.getKeyValue())) {
            keyValueDto = new KeyValueDto(keyValueDto.getId(),keyValueEntity.getKeyName(), keyValueEntity.getKeyValue());
        }
        return keyValueDto;
    }


    public boolean postKeyValue(KeyValueDto keyValueDto) {
        boolean saved = false;
        try {
            //validate input
            if (keyValueDto == null || StringUtils.isEmpty(keyValueDto.getKeyValue())) {
                return saved;
            }

            //create key from value
            keyValueDto.setKeyName(getSha256(keyValueDto.getKeyValue()));;

            //if key does not exist save it
            KeyValueEntity findKeyValueEntity = keyValueRepository.findByKeyName(keyValueDto.getKeyName());
            if (findKeyValueEntity == null) {
                //save entry
                KeyValueEntity keyValueEntity = new KeyValueEntity(null,keyValueDto.getKeyName(), keyValueDto.getKeyValue());
                keyValueRepository.save(keyValueEntity);
                saved = true;
            } else {
                saved = false;
            }

        } catch (Exception e) {
            saved = false;
        }
        return saved;
    }

    public static String getSha256(String url) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(url.getBytes(StandardCharsets.UTF_8));
        return hash.toString().substring(0, 8);

    }

}
