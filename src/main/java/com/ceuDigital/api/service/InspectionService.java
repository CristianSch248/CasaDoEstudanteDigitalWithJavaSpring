package com.ceuDigital.api.service;

import com.ceuDigital.api.domain.apartment.Apartment;
import com.ceuDigital.api.domain.user.User;
import com.ceuDigital.api.domain.inspection.Inspection;
import com.ceuDigital.api.domain.inspection.InspectionRequestDTO;
import com.ceuDigital.api.repositories.ApartmentRepository;
import com.ceuDigital.api.repositories.InspectionRepository;
import com.ceuDigital.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InspectionService
{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private InspectionRepository inspectionRepository;

    public Inspection createInspection( InspectionRequestDTO inspectionDTO )
    {
        User student = userRepository.findById(inspectionDTO.id_student()).get();
        User confirming = userRepository.findById(inspectionDTO.confirming_user()).get();
        Apartment apartment = apartmentRepository.findById(inspectionDTO.id_apartment()).get();

        Inspection newInspection = new Inspection();

        newInspection.setStudent(student);
        newInspection.setConfirming_user(confirming);
        newInspection.setApartment(apartment);
        newInspection.setObservations(inspectionDTO.observations());
        newInspection.setInspection_date(inspectionDTO.inspection_date());
        newInspection.setInspection_time(inspectionDTO.inspection_time());
        newInspection.setStatus(inspectionDTO.status());

        inspectionRepository.save(newInspection);

        return newInspection;
    }
}
