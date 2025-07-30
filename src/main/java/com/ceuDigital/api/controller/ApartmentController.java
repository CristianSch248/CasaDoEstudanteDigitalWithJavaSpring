package com.ceuDigital.api.controller;

import com.ceuDigital.api.domain.apartment.ApartmentRequestDTO;
import com.ceuDigital.api.domain.apartment.Apartment;
import com.ceuDigital.api.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/apartament")
public class ApartmentController
{
    @Autowired
    private ApartmentService apartmentService;

    @PostMapping
    public ResponseEntity<Apartment> create (@RequestBody ApartmentRequestDTO apartmentRequestDTO)
    {
        Apartment newApartment = this.apartmentService.createApartment( apartmentRequestDTO );

        return ResponseEntity.ok(newApartment);
    }
}
