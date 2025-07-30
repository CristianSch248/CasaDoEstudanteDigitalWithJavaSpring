package com.ceuDigital.api.service;

import com.ceuDigital.api.domain.apartment.ApartmentDetailsDTO;
import com.ceuDigital.api.domain.apartment.ApartmentRequestDTO;
import com.ceuDigital.api.domain.apartment.Apartment;
import com.ceuDigital.api.domain.apartment.ApartmentUpdateRequestDTO;
import com.ceuDigital.api.domain.user.User;
import com.ceuDigital.api.domain.user.SimpleUserProjection;
import com.ceuDigital.api.domain.asset.Asset;
import com.ceuDigital.api.domain.inspection.Inspection;
import com.ceuDigital.api.domain.maintenance.Maintenance;
import com.ceuDigital.api.domain.vacancy.Vacancy;
import com.ceuDigital.api.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ApartmentService
{

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private VacancyRepository vacancyRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AssetRepository assetRepository;
    @Autowired
    private InspectionRepository inspectionRepository;
    @Autowired
    private MaintenanceRepository maintenanceRepository;

    public Apartment createApartment ( ApartmentRequestDTO apartmentDTO )
    {
        Apartment newApartment = new Apartment();

        newApartment.setApartment_number( apartmentDTO.apartment_number() );
        newApartment.setApartment_block( apartmentDTO.apartment_block() );
        newApartment.setTotal_vacancies( apartmentDTO.total_vacancies() );

        apartmentRepository.save( newApartment);

        return newApartment;
    }

    public List<Apartment> findAllApartments ()
    {
        return apartmentRepository.findAll();
    }

    public Apartment updateApartment ( ApartmentUpdateRequestDTO apartmentUpdateDTO )
    {
        Apartment Updateapartment = apartmentRepository.findById(apartmentUpdateDTO.id()).orElse(null);

        Updateapartment.setApartment_number( apartmentUpdateDTO.apartment_number() );
        Updateapartment.setApartment_block( apartmentUpdateDTO.apartment_block() );
        Updateapartment.setTotal_vacancies( apartmentUpdateDTO.total_vacancies() );

        apartmentRepository.save( Updateapartment );

        return Updateapartment;
    }

    public ResponseEntity<?> findApartment ( UUID id )
    {
        Optional<Apartment> optApartment = apartmentRepository.findById(id);
        if (optApartment.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("success", false, "message", "Dados do seu apartamento não encontrados"));
        }

        Apartment apartment = optApartment.get();

        List<Vacancy> activeVacancies = vacancyRepository.findByApartmentAndActiveTrue(apartment);

        List<UUID> userIds = activeVacancies.stream()
                                            .map(v -> v.getStudent().getId())
                                            .filter(Objects::nonNull)
                                            .toList();

        List<SimpleUserProjection> moradores = userRepository.findAllByIdIn(userIds);

        List<Asset>       patrimonio  = assetRepository.findByApartment(apartment);
        List<Inspection>  vistorias   = inspectionRepository.findByApartment(apartment);
        List<Maintenance> manutencoes = maintenanceRepository.findByApartment(apartment);

        ApartmentDetailsDTO dto = new ApartmentDetailsDTO(apartment, moradores, patrimonio, vistorias, manutencoes);
        return ResponseEntity.ok(Map.of("success", true, "message", dto));
    }


}