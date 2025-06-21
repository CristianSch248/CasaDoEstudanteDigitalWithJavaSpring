package com.ceuDigital.api.domain.apartamento;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "apartments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Apartment {

    @Id
    @GeneratedValue
    private UUID id;

    private Long apartment_number;
    private Long apartment_block;

    private Integer total_vacancies;
}