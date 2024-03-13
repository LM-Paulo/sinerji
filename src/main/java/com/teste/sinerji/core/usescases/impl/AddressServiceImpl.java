package com.teste.sinerji.core.usescases.impl;

import com.teste.sinerji.adapters.database.AddressRepository;
import com.teste.sinerji.core.domain.AddressEntity;
import com.teste.sinerji.core.domain.dto.AddressDto;
import com.teste.sinerji.core.domain.exception.BusinessException;
import com.teste.sinerji.core.ports.service.AdressService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AddressServiceImpl implements AdressService {
    private final AddressRepository repository;

    public AddressServiceImpl(AddressRepository repository){
        this.repository = repository;
    }

    @Override
    public Optional<AddressEntity> getById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Long id) throws BusinessException {
        Optional<AddressEntity> address = Optional.ofNullable(repository.findById(id).orElseThrow(() -> new BusinessException("Address with ID '" + id + "' not found.")));
        this.repository.deleteById(address.get().getId());
    }

    @Override
    @Transactional
    public void update(Long id, AddressDto addressDto) throws BusinessException {
        Optional<AddressEntity> optionalAddress = repository.findById(id);
        if (optionalAddress.isPresent()) {
            repository.updateAddressById(id, addressDto.getPublicPlace(), addressDto.getNumber(), addressDto.getZipCode(), addressDto.getCity(), addressDto.getState());
        } else {
            throw new BusinessException("Address with ID " + id + " not found");
        }
    }

    @Override
    public void createAddress(AddressDto addressDto) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setEntity(addressDto);
        repository.save(addressEntity);
    }

    @Override
    public Page<AddressEntity> listAllAddress(Sort.Direction direction, String properties, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(direction, properties));
        return repository.findAll(pageable);
    }
}
