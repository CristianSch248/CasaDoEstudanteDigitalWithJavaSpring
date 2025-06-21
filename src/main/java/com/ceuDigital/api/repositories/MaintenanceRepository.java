package com.ceuDigital.api.repositories;

import com.ceuDigital.api.domain.manutencao.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MaintenanceRepository extends JpaRepository<Maintenance, UUID> {
}
