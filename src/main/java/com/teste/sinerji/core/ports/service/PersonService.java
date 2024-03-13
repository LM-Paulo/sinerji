package com.teste.sinerji.core.ports.service;

import com.teste.sinerji.core.domain.AddressEntity;
import com.teste.sinerji.core.domain.PersonEntity;
import com.teste.sinerji.core.domain.dto.PersonDto;
import com.teste.sinerji.core.domain.exception.BusinessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public interface PersonService {
    Optional<PersonEntity> getById(Long id);

    void delete(Long id) throws BusinessException;

    void update(Long id, PersonDto personDto) throws BusinessException;

    void createAddress(PersonDto personDto);

    Page<PersonEntity> listAllPerson(Sort.Direction direction, String properties, Integer page, Integer size);
}
