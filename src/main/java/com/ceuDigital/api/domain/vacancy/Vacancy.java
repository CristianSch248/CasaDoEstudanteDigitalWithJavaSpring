package com.ceuDigital.api.domain.vacancy;

import com.ceuDigital.api.domain.apartment.Apartment;
import com.ceuDigital.api.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "vacancies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vacancy
{

    @Id
    @GeneratedValue
    private UUID id;

    private LocalDate move_in_date;
    private LocalDate move_out_date;
    private String observations;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private User student;

    @ManyToOne
    @JoinColumn(name = "id_apartment")
    private Apartment apartment;
}
