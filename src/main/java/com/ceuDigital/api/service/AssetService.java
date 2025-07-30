package com.ceuDigital.api.service;

import com.ceuDigital.api.domain.apartment.Apartment;
import com.ceuDigital.api.domain.asset.Asset;
import com.ceuDigital.api.domain.asset.AssetRequestDTO;
import com.ceuDigital.api.repositories.ApartmentRepository;
import com.ceuDigital.api.repositories.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetService
{

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private AssetRepository assetRepository;

    public Asset createAsset (AssetRequestDTO assetDTO)
    {
        Apartment apartment = this.apartmentRepository.findById(assetDTO.id_apartment()).get();

        Asset newAsset = new Asset();

        newAsset.setApartment(apartment);
        newAsset.setDescription(assetDTO.description());
        newAsset.setCondition(assetDTO.condition());

        assetRepository.save(newAsset);

        return newAsset;
    }

}
