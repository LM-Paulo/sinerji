package com.teste.sinerji.core.domain.dto;

import com.teste.sinerji.core.domain.PersonEntity;
import lombok.Data;

@Data
public class AddressDto {

    private String state;

    private String city;

    private String publicPlace;

    private Integer number;

    private String zipCode;

}
