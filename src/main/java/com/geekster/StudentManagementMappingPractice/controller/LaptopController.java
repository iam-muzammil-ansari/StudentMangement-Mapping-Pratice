package com.geekster.StudentManagementMappingPractice.controller;


import com.geekster.StudentManagementMappingPractice.model.Laptop;
import com.geekster.StudentManagementMappingPractice.model.enums.Brand;
import com.geekster.StudentManagementMappingPractice.service.LaptopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class LaptopController {
    @Autowired
    LaptopService laptopService;


    //    Task -- 1 --> Adding Laptop --> Create --CR(Crud Repository)
    @PostMapping("laptop")
    public String addLaptop(@RequestBody @Valid Laptop laptop) {
        return laptopService.addLaptop(laptop);
    }

    //    Task -- 2 --> Getting All Laptop --> READ/GET --CF(Custom Finder)
    @GetMapping("laptops")
    public List<Laptop> getLaptopByBrand(@RequestParam Brand brand) {
        return laptopService.getLaptopByBrand(brand);
    }

    //    Task -- 3 --> Update Laptop information by brand --> Update --CQ(Custom Query)
    @PutMapping("laptop")
    public String updateLaptopInfoByBrand(@RequestParam Brand brand, @RequestParam Integer price) {
        return laptopService.updateLaptopInfoByBrand(brand, price);
    }

    //    Task -- 4 --> delete all Laptops by brand --> Delete --CR(Custom Repository)
    @DeleteMapping("laptops")
    public String removeAllLaptopByBrand(@RequestParam Brand brand) {
        return laptopService.removeAllLaptopByBrand(brand);
    }
}