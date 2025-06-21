package com.ceuDigital.api.controller;

import com.ceuDigital.api.domain.vaga.Vacancy;
import com.ceuDigital.api.domain.vaga.VacancyRequestDTO;
import com.ceuDigital.api.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vacancie")
public class VacancyController
{
    @Autowired
    private VacancyService vacancyService;

    @PostMapping
    public ResponseEntity<Vacancy> create (@RequestBody VacancyRequestDTO VacancyDTO)
    {
        Vacancy newVacancy = this.vacancyService.createVacancy(VacancyDTO);

        return ResponseEntity.ok(newVacancy);
    }
}
