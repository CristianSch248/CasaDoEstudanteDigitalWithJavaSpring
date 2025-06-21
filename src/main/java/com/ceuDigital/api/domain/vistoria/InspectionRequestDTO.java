package com.ceuDigital.api.domain.vistoria;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record InspectionRequestDTO( UUID id_student,
                                    UUID confirming_user,
                                    UUID id_apartment,
                                    String observations,
                                    LocalDate inspection_date,
                                    String inspection_time,
                                    Integer status )
{
}
