package com.geekster.StudentManagementMappingPractice.service;

import com.geekster.StudentManagementMappingPractice.model.Laptop;
import com.geekster.StudentManagementMappingPractice.model.enums.Brand;
import com.geekster.StudentManagementMappingPractice.repository.ILaptopRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {
    @Autowired
    ILaptopRepo iLaptopRepo;

    public String addLaptop(Laptop laptop) {
        iLaptopRepo.save(laptop);
        return "Laptop Added Successfully!!!";
    }

    @Transactional
    public String removeAllLaptopByBrand(Brand brand) {
        Integer countDelete = iLaptopRepo.removeAllLaptopByBrand(brand.name());
        if(countDelete > 0) {
            return "Laptop Deleted Successfully!!";
        }else {
            return "Laptop not deleted because this Brand does not exist";
        }
    }

    @Transactional
    public String updateLaptopInfoByBrand(Brand brand, Integer price) {
        Integer countUpdate = iLaptopRepo.updateLaptopInfoByBrand(brand.name(), price);
        if(countUpdate > 0) {
            return "Laptop Information updated Successfully!!";
        }else {
            return "Laptop information not updated because this Brand does not exist";
        }
    }

    public List<Laptop> getLaptopByBrand(Brand brand) {
        return iLaptopRepo.findByLaptopBrand(brand);
    }
}