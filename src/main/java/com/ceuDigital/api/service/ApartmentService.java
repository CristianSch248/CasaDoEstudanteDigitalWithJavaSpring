package com.ceuDigital.api.service;

import com.ceuDigital.api.domain.apartamento.ApartmentRequestDTO;
import com.ceuDigital.api.domain.apartamento.Apartment;
import com.ceuDigital.api.repositories.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApartmentService
{

    @Autowired
    private ApartmentRepository apartmentRepository;

    public Apartment createApartment (ApartmentRequestDTO apartmentDTO)
    {
        Apartment newApartment = new Apartment();

        newApartment.setApartment_number( apartmentDTO.apartment_number() );
        newApartment.setApartment_block( apartmentDTO.apartment_block() );
        newApartment.setTotal_vacancies( apartmentDTO.total_vacancies() );

        apartmentRepository.save(newApartment);

        return newApartment;
    }
}