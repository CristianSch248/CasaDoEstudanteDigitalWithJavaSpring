package com.ceuDigital.api.controller;

import com.ceuDigital.api.domain.patrimonio.Asset;
import com.ceuDigital.api.domain.patrimonio.AssetRequestDTO;
import com.ceuDigital.api.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/asset")
public class AssetController
{

    @Autowired
    private AssetService assetService;

    @PostMapping
    public ResponseEntity<Asset> create (@RequestBody AssetRequestDTO assetDTO)
    {
        Asset asset = this.assetService.createAsset(assetDTO);

        return ResponseEntity.ok(asset);
    }

}
