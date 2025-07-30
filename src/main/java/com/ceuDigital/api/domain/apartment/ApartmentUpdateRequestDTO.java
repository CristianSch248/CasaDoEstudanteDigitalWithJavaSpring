package com.ceuDigital.api.domain.apartment;

import java.util.UUID;

public record ApartmentUpdateRequestDTO( UUID id,
                                         Long apartment_number,
                                         Long apartment_block,
                                         Integer total_vacancies ) {
}
