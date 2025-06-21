package com.ceuDigital.api.service;

import com.ceuDigital.api.domain.apartamento.Apartment;
import com.ceuDigital.api.domain.usuario.User;
import com.ceuDigital.api.domain.vaga.Vacancy ;
import com.ceuDigital.api.domain.vaga.VacancyRequestDTO;
import com.ceuDigital.api.repositories.ApartmentRepository;
import com.ceuDigital.api.repositories.UserRepository;
import com.ceuDigital.api.repositories.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacancyService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private VacancyRepository vacancyRepository;

    public Vacancy createVacancy (VacancyRequestDTO vacancyDTO)
    {
        Apartment apartment = this.apartmentRepository.findById(vacancyDTO.id_apartment()).get();
        User user = this.userRepository.findById(vacancyDTO.id_student()).get();

        Vacancy newVacancy = new Vacancy();
        newVacancy.setApartment(apartment);
        newVacancy.setStudent(user);
        newVacancy.setActive(vacancyDTO.active());
        newVacancy.setMove_in_date(vacancyDTO.move_in_date());
        newVacancy.setMove_out_date(vacancyDTO.move_out_date());
        newVacancy.setObservations(vacancyDTO.observations());

        vacancyRepository.save(newVacancy);

        return newVacancy;
    }
}