package com.teste.sinerji.core.ports.service;

import com.teste.sinerji.core.domain.AddressEntity;
import com.teste.sinerji.core.domain.dto.AddressDto;
import com.teste.sinerji.core.domain.exception.BusinessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Optional;


public interface AdressService {

    Optional<AddressEntity> getById(Long id);

    void delete(Long id) throws BusinessException;

    void update(Long id, AddressDto addressDto) throws BusinessException;

    void createAddress(AddressDto addressDto);

    Page<AddressEntity> listAllAddress(Sort.Direction direction, String properties, Integer page, Integer size);
}
