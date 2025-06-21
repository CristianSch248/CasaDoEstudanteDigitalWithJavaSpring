package com.ceuDigital.api.domain.apartamento;

public record ApartmentRequestDTO(
        Long apartment_number,
        Long apartment_block,
        Integer total_vacancies)
{ }
