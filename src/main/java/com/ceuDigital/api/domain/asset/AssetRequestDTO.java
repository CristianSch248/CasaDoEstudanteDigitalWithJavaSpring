package com.ceuDigital.api.domain.asset;

import java.util.UUID;

public record AssetRequestDTO( UUID id_apartment,
                               String description,
                               String condition ) {
}
