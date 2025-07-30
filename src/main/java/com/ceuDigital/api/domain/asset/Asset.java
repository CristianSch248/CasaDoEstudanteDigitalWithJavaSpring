package com.ceuDigital.api.domain.asset;

import com.ceuDigital.api.domain.apartment.Apartment;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "assets ")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asset
{
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_apartment")
    private Apartment apartment;

    private String description;
    private String condition;
}

