package com.example.polls.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.polls.dto.CustomerDto;
import com.example.polls.model.ReservationTerrain;
import com.example.polls.repository.CustomerTerainRepository;
import com.example.polls.repository.ReservationTerrainRepository;
import com.example.polls.service.CustomerTerrainService;

import java.util.List;

@RequestMapping("/api/customer")
@CrossOrigin("*")
@RestController
public class CustomerController {


    @Autowired
    private ReservationTerrainRepository customerTerrainService;
    
    @Autowired
    private CustomerTerainRepository customerTerainRepository;
    
    @GetMapping("/getCustomerReservations/{customerId}")
    public ResponseEntity<?> getCustomerReservations(@PathVariable Long customerId) {
        try {
            List<ReservationTerrain> reservations = customerTerrainService.findterainreservecutomser(customerId);
            return ResponseEntity.ok(reservations);
        } catch (ApplicationContextException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
