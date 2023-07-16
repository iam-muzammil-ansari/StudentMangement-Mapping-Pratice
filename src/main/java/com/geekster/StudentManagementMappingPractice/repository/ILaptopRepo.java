package com.geekster.StudentManagementMappingPractice.repository;

import com.geekster.StudentManagementMappingPractice.model.Laptop;
import com.geekster.StudentManagementMappingPractice.model.enums.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILaptopRepo extends JpaRepository<Laptop, Integer> {
    List<Laptop> findByLaptopBrand(Brand brand);

    @Modifying
    @Query(value = "update laptop set laptop_price = :price where laptop_brand = :brand", nativeQuery = true)
    Integer updateLaptopInfoByBrand(String brand, Integer price);

    @Modifying
    @Query(value = "Delete from laptop where laptop_brand = :name", nativeQuery = true)
    Integer removeAllLaptopByBrand(String name);
}