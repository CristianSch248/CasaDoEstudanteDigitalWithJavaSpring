package com.ceuDigital.api.repositories;

import com.ceuDigital.api.domain.apartment.Apartment;
import com.ceuDigital.api.domain.inspection.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InspectionRepository extends JpaRepository<Inspection, UUID>
{
    List<Inspection> findByApartment(Apartment apartment);

}
