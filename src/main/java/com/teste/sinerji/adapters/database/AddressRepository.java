package com.teste.sinerji.adapters.database;

import com.teste.sinerji.core.domain.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    @Modifying
    @Query("UPDATE AddressEntity a " +
            "SET a.publicPlace = :publicPlace, a.number = :number, a.zipCode = :zipCode, " +
            "a.city = :city, a.state = :state, a.city = :city WHERE a.id = :id")
    void updateAddressById(@Param("id") Long id,@Param("publicPlace") String publicPlace,@Param("number") Integer number,
                           @Param("zipCode")String zipCode,@Param("city") String city,@Param("state") String state);
}
