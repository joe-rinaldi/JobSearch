package BofA;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/*
todo add EmployeeNotFoundException GlobalExceptionHandler and @RestControllerAdvice
 */
@RestController
@RequestMapping("/api/v1/")
public class KeyValueController{

    final private KeyValueService KeyValueService;

    public KeyValueController(KeyValueService KeyValueService)
    {
        this.KeyValueService = KeyValueService;
    }

    @GetMapping(value="shortenurl/{longUrl}")
    public ResponseEntity<KeyValueDto> getShortenUrl(@PathVariable String longUrl){

        KeyValueDto keyValueDto = KeyValueService.getKeyValue(longUrl);
        if (keyValueDto.getId() == null){
            return new ResponseEntity<>(keyValueDto, HttpStatus.NOT_FOUND);		 }
        else{
            return new ResponseEntity<>(keyValueDto, HttpStatus.OK);
        }
    }

    @PostMapping(value="shortenurl")
    public ResponseEntity<KeyValueDto> postShortenUrl(@RequestBody KeyValueDto keyValueDto){
        boolean saved = KeyValueService.postKeyValue(keyValueDto);
        if (saved){
            return new ResponseEntity<>(keyValueDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(keyValueDto, HttpStatus.BAD_REQUEST);
        }
    }

}
