package com.teste.sinerji.core.domain;

import com.teste.sinerji.core.domain.dto.AddressDto;
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
@Table(name="tbl_address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String state;

    @NotEmpty
    private String city;

    @NotEmpty
    private String publicPlace;


    private Integer number;

    @NotEmpty
    private String zipCode;

    @OneToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;


    public void setEntity(AddressDto addressDto){
        this.publicPlace = addressDto.getPublicPlace();
        this.state = addressDto.getState();
        this.city = addressDto.getCity();
        this.number = addressDto.getNumber();
        this.zipCode = addressDto.getZipCode();
    }
}
