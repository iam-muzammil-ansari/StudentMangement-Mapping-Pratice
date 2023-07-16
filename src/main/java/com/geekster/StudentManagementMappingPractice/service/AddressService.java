package com.geekster.StudentManagementMappingPractice.service;

import com.geekster.StudentManagementMappingPractice.model.Address;
import com.geekster.StudentManagementMappingPractice.repository.IAddressRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    IAddressRepo iAddressRepo;
    public String addAddress(Address address) {
        iAddressRepo.save(address);
        return "Address Added Successfully!!!";
    }

    public Address getAddressByZipCode(Integer code) {
        return iAddressRepo.findByAddressZipCode(code);
    }

    @Transactional
    public String updateAddressInfoByCountry(String country, String state) {
        Integer countUpdate = iAddressRepo.updateAddressInfoByCountry(country, state);
        if(countUpdate > 0) {
            return "Address Information updated Successfully!!";
        }else {
            return "Address information not updated because this Country does not exist";
        }
    }

    public String removeAddressById(Integer addressId) {
        iAddressRepo.deleteById(addressId);
        return "Address Information updated Successfully or address id does not exist";
    }
}