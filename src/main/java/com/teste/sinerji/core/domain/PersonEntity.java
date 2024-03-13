package com.teste.sinerji.core.domain;

import com.teste.sinerji.core.domain.dto.PersonDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    private Integer age;

    @NotEmpty
    private String sex;

    @OneToOne
    private AddressEntity address;

    public void setEntity(PersonDto personDto) {
        this.name = personDto.getName();
        this.age = personDto.getAge();
        this.sex = personDto.getSex();
        this.address = personDto.getAddress();
    }
}
