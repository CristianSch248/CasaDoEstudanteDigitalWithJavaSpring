package com.ceuDigital.api.repositories;

import com.ceuDigital.api.domain.vistoria.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InspectionRepository extends JpaRepository<Inspection, UUID> {
}
