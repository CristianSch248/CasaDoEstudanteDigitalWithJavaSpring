package com.ceuDigital.api.domain.vacancy;

import java.time.LocalDate;
import java.util.UUID;

public record VacancyRequestDTO( UUID id_student,
                                 UUID id_apartment,
                                 LocalDate move_in_date,
                                 LocalDate move_out_date,
                                 String observations,
                                 Boolean active )
{
}
