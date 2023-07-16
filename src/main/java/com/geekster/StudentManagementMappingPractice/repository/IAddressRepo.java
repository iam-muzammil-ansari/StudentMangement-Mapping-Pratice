package com.geekster.StudentManagementMappingPractice.repository;

import com.geekster.StudentManagementMappingPractice.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IAddressRepo extends JpaRepository<Address, Integer> {
    Address findByAddressZipCode(Integer code);

    @Modifying
    @Query(value = "update address set address_state = :state where country = :country", nativeQuery = true)
    Integer updateAddressInfoByCountry(String country, String state);
}