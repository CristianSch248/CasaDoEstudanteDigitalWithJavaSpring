package com.ceuDigital.api.repositories;

import com.ceuDigital.api.domain.apartment.Apartment;
import com.ceuDigital.api.domain.maintenance.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MaintenanceRepository extends JpaRepository<Maintenance, UUID>
{
    List<Maintenance> findByApartment(Apartment apartment);

}
