package com.teste.sinerji.adapters.database;

import com.teste.sinerji.core.domain.AddressEntity;
import com.teste.sinerji.core.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    @Modifying
    @Query("UPDATE PersonEntity p " +
            "SET p.name = :name, p.age = :age, p.sex = :sex, p.address = :address WHERE p.id = :id")
    void updatePersonById(@Param("id")Long id,@Param("name") String name,@Param("age") Integer age,
                          @Param("sex")String sex,@Param("address") AddressEntity address);
}
