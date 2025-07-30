package com.ceuDigital.api.domain.apartment;

import com.ceuDigital.api.domain.asset.Asset;
import com.ceuDigital.api.domain.inspection.Inspection;
import com.ceuDigital.api.domain.maintenance.Maintenance;
import com.ceuDigital.api.domain.user.SimpleUserProjection;

import java.util.List;

public record ApartmentDetailsDTO(
        Apartment dadosAP,
        List<SimpleUserProjection> moradores,
        List<Asset> patrimonio,
        List<Inspection> vistorias,
        List<Maintenance> manutencoes
) {}
