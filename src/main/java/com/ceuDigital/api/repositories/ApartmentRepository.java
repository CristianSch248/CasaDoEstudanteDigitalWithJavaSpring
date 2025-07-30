package com.ceuDigital.api.repositories;

import com.ceuDigital.api.domain.apartment.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApartmentRepository extends JpaRepository<Apartment, UUID> {
}
