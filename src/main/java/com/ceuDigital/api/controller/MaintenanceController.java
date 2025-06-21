package com.ceuDigital.api.controller;


import com.ceuDigital.api.domain.manutencao.Maintenance;
import com.ceuDigital.api.domain.manutencao.MaintenanceRequestDTO;
import com.ceuDigital.api.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceController
{
    @Autowired
    private MaintenanceService maintenanceService;

    @PostMapping
    public ResponseEntity<Maintenance> create (@RequestBody MaintenanceRequestDTO maintenanceDTO)
    {
        Maintenance newMaintenance = this.maintenanceService.createMaintenance(maintenanceDTO);

        return ResponseEntity.ok(newMaintenance);
    }
}