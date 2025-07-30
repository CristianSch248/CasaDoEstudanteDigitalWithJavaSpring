package com.ceuDigital.api.domain.maintenance;

import java.time.LocalDate;
import java.util.UUID;

public record MaintenanceRequestDTO( UUID id_student,
                                     UUID id_confirming_user,
                                     UUID id_apartment,
                                     String situation,
                                     String material_used,
                                     String activity_description,
                                     LocalDate maintenance_date,
                                     String maintenance_time,
                                     Integer status )
{
}
