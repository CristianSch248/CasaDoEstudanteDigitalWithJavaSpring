package com.ceuDigital.api.repositories;

import com.ceuDigital.api.domain.apartment.Apartment;
import com.ceuDigital.api.domain.asset.Asset ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AssetRepository extends JpaRepository<Asset , UUID>
{
    List<Asset> findByApartment(Apartment apartment);


}
