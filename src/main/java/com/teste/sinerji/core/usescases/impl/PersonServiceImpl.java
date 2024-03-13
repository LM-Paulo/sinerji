package com.teste.sinerji.core.usescases.impl;


import com.teste.sinerji.adapters.database.PersonRepository;
import com.teste.sinerji.core.domain.AddressEntity;
import com.teste.sinerji.core.domain.PersonEntity;
import com.teste.sinerji.core.domain.dto.PersonDto;
import com.teste.sinerji.core.domain.exception.BusinessException;
import com.teste.sinerji.core.ports.service.PersonService;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository){
        this.repository = repository;
    }


    @Override
    public Optional<PersonEntity> getById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Long id) throws BusinessException {
        Optional<PersonEntity> person = Optional.ofNullable(repository.findById(id).orElseThrow(() -> new BusinessException("Address with ID '" + id + "' not found.")));
        this.repository.deleteById(person.get().getId());

    }

    @Override
    @Transactional
    public void update(Long id, PersonDto personDto) throws BusinessException {
        Optional<PersonEntity> optionalPerson = repository.findById(id);
        if (optionalPerson.isPresent()) {
            repository.updatePersonById(id, personDto.getName(), personDto.getAge(), personDto.getSex(), personDto.getAddress());
        } else {
            throw new BusinessException("Address with ID " + id + " not found");
        }

    }

    @Override
    public void createAddress(PersonDto personDto) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setEntity(personDto);
        repository.save(personEntity);

    }

    @Override
    public Page<PersonEntity> listAllPerson(Sort.Direction direction, String properties, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(direction, properties));
        return repository.findAll(pageable);
    }
}
