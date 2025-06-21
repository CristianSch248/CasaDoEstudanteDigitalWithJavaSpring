package com.ceuDigital.api.domain.vistoria;

import com.ceuDigital.api.domain.apartamento.Apartment;
import com.ceuDigital.api.domain.usuario.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "inspections")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inspection {

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

    private LocalDate inspection_date;
    private String inspection_time;
    private Integer status;
    private String observations ;
}
