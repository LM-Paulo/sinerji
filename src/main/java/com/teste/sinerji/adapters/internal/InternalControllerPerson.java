package com.teste.sinerji.adapters.internal;

import com.teste.sinerji.core.domain.PersonEntity;
import com.teste.sinerji.core.domain.dto.PersonDto;
import com.teste.sinerji.core.domain.exception.BusinessException;
import com.teste.sinerji.core.usescases.impl.PersonServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/person")
public class InternalControllerPerson {
    private final PersonServiceImpl personService;

    @Autowired
    public InternalControllerPerson(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @PostMapping("/createPerson")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createAddress(@RequestBody @Valid PersonDto personDto){
        personService.createAddress(personDto);
        return ResponseEntity.ok("Successfully created person");
    }

    @GetMapping("/listAllPerson")
    public Page<PersonEntity> listAllPerson(
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "properties", defaultValue = "name") String properties,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size){

        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        return personService.listAllPerson(sortDirection,properties,page,size);
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable("id") Long id, @RequestBody @Valid PersonDto personDto) throws BusinessException {
        personService.update(id,personDto);
        return ResponseEntity.ok("Person updated successfully");
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable("id") Long id) throws BusinessException {
        personService.delete(id);
    }

    @GetMapping("/getById/{id}")
    public Optional<PersonEntity> getById(@PathVariable("id") Long id){
        return personService.getById(id);
    }

}
