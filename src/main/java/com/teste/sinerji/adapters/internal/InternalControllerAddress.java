package com.teste.sinerji.adapters.internal;

import com.teste.sinerji.core.domain.AddressEntity;
import com.teste.sinerji.core.domain.dto.AddressDto;
import com.teste.sinerji.core.domain.exception.BusinessException;
import com.teste.sinerji.core.usescases.impl.AddressServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping("api/address")
public class InternalControllerAddress {
    private final AddressServiceImpl addressService;

    @Autowired
    public InternalControllerAddress(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/createAddress")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createAddress(@RequestBody @Valid AddressDto addressDto){
        addressService.createAddress(addressDto);
        return ResponseEntity.ok("Successfully created address");
    }

    @GetMapping("/listAllAddress")
    public Page<AddressEntity> listAllAddress(
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "properties", defaultValue = "state") String properties,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size){

        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        return addressService.listAllAddress(sortDirection,properties,page,size);
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable("id") Long id, @RequestBody @Valid AddressDto addressDto) throws BusinessException {
        addressService.update(id,addressDto);
        return ResponseEntity.ok("Address updated successfully");
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddress(@PathVariable("id") Long id) throws BusinessException {
        addressService.delete(id);
    }

    @GetMapping("/getById/{id}")
    public Optional<AddressEntity> getById(@PathVariable("id") Long id){
        return addressService.getById(id);
    }
}
