package com.ceuDigital.api.controller;

import com.ceuDigital.api.domain.vistoria.Inspection;
import com.ceuDigital.api.domain.vistoria.InspectionRequestDTO;
import com.ceuDigital.api.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inspection")
public class InspectionController
{

    @Autowired
    private InspectionService inspectionService;

    @PostMapping
    public ResponseEntity<Inspection> create (@RequestBody InspectionRequestDTO inspectionDTO)
    {
        Inspection inspection = inspectionService.createInspection(inspectionDTO);

        return ResponseEntity.ok(inspection);
    }
}