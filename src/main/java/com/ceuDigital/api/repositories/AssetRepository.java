package com.ceuDigital.api.repositories;

import com.ceuDigital.api.domain.patrimonio.Asset ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AssetRepository extends JpaRepository<Asset , UUID> {
}
