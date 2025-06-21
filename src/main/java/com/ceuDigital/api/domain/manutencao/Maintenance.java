package com.ceuDigital.api.domain.manutencao;

import com.ceuDigital.api.domain.apartamento.Apartment;
import com.ceuDigital.api.domain.usuario.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "maintenances")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Maintenance
{
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private User student;

    @ManyToOne
    @JoinColumn(name = "id_confirming_user")
    private User confirming_user;

    @ManyToOne
    @JoinColumn(name = "id_apartment")
    private Apartment apartment;

    private String situation;
    private String material_used;
    private String activity_description;

    private LocalDate maintenance_date;
    private String maintenance_time;
    private Integer status;
}

