package com.teste.sinerji.core.domain.dto;

import com.teste.sinerji.core.domain.AddressEntity;
import lombok.Data;

@Data
public class PersonDto {

    private String name;

    private Integer age;

    private String sex;

    private AddressEntity address;
}
