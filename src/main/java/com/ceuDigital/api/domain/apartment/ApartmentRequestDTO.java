package com.ceuDigital.api.domain.apartment;

public record ApartmentRequestDTO(
        Long apartment_number,
        Long apartment_block,
        Integer total_vacancies)
{ }
