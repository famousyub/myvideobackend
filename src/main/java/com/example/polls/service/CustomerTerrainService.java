package com.example.polls.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polls.dto.CustomerDto;
import com.example.polls.model.Customer;
import com.example.polls.repository.CustomerTerainRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomerTerrainService {


    @Autowired
    private CustomerTerainRepository customerTerainRepository;

 public    List<CustomerDto> getAllCustomer()
    {
        List<CustomerDto> po = new ArrayList<>();

        return  customerTerainRepository.findAll().stream()
                .map( (er ) -> {

                            CustomerDto pk = new CustomerDto();
                            pk.setCustomerId(er.getCustomerId());
                            pk.setEmailAddress(er.getEmailAddress());
                            pk.setFirstName(er.getFirstName());
                            pk.setLastName(er.getLastName());
                            pk.setPhoneNo(er.getPhoneNo());

                              po.add(pk);
                              return  pk ;
                }


                ).collect(Collectors.toList());

    }

    void createCustomer(CustomerDto er){

        Customer pk = new Customer();

        pk.setCustomerId(er.getCustomerId());
        pk.setEmailAddress(er.getEmailAddress());
        pk.setFirstName(er.getFirstName());
        pk.setLastName(er.getLastName());
        pk.setPhoneNo(er.getPhoneNo());
        customerTerainRepository.save(pk);
    }
}
