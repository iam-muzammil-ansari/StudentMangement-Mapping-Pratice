package com.geekster.StudentManagementMappingPractice.controller;

import com.geekster.StudentManagementMappingPractice.model.Address;
import com.geekster.StudentManagementMappingPractice.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController

public class AddressController {
    @Autowired
    AddressService addressService;

    //    Task -- 1 --> Adding Address --> Create --CR(Crud Repository)
    @PostMapping("address")
    public String addAddress(@RequestBody @Valid Address address) {
        return addressService.addAddress(address);
    }

    //    Task -- 2 --> Getting All Address --> READ/GET --CF(Custom Finder)
    @GetMapping("address")
    public Address getAddressByZipCode(@RequestParam Integer code) {
        return addressService.getAddressByZipCode(code);
    }

    //    Task -- 3 --> Update Address information by Country --> Update --CQ(Custom Query)
    @PutMapping("address")
    public String updateAddressInfoByCountry(@RequestParam String country, @RequestParam String state) {
        return addressService.updateAddressInfoByCountry(country, state);
    }

    //    Task -- 4 --> delete Address by Id --> Delete --CR(Custom Repository)
    @DeleteMapping("address")
    public String removeAllAddressById(@RequestParam Integer addressId) {
        return addressService.removeAddressById(addressId);
    }
}