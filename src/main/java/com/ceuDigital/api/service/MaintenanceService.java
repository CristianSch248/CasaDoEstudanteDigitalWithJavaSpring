package com.ceuDigital.api.service;

import com.ceuDigital.api.domain.apartamento.Apartment;
import com.ceuDigital.api.domain.manutencao.Maintenance;
import com.ceuDigital.api.domain.manutencao.MaintenanceRequestDTO;
import com.ceuDigital.api.domain.usuario.User;
import com.ceuDigital.api.repositories.ApartmentRepository;
import com.ceuDigital.api.repositories.MaintenanceRepository;
import com.ceuDigital.api.repositories.UserRepository;
import com.ceuDigital.api.repositories.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    public Maintenance createMaintenance (MaintenanceRequestDTO maintenanceDTO)
    {
        User student = userRepository.findById(maintenanceDTO.id_student()).get();
        User confirming = userRepository.findById(maintenanceDTO.id_confirming_user()).get();
        Apartment apartment = apartmentRepository.findById(maintenanceDTO.id_apartment()).get();

        Maintenance newMaintenance = new Maintenance();

        newMaintenance.setStudent(student);
        newMaintenance.setConfirming_user(confirming);
        newMaintenance.setApartment(apartment);
        newMaintenance.setSituation(maintenanceDTO.situation());
        newMaintenance.setActivity_description(maintenanceDTO.activity_description());
        newMaintenance.setMaterial_used(maintenanceDTO.material_used());
        newMaintenance.setMaintenance_date(maintenanceDTO.maintenance_date());
        newMaintenance.setMaintenance_time(maintenanceDTO.maintenance_time());
        newMaintenance.setStatus(maintenanceDTO.status());

        maintenanceRepository.save( newMaintenance );

        return newMaintenance;
    }
}
