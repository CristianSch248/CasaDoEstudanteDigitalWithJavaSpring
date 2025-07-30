package com.ceuDigital.api.repositories;

import com.ceuDigital.api.domain.apartment.Apartment;
import com.ceuDigital.api.domain.vacancy.Vacancy ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VacancyRepository extends JpaRepository<Vacancy, UUID>
{
    List<Vacancy> findByApartmentAndActiveTrue(Apartment apartment);

}
