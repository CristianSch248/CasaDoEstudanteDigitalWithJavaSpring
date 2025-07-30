package com.ceuDigital.api.domain.user;

import java.util.UUID;

public interface SimpleUserProjection
{
    UUID getId();
    String getName();
    String getEmail();
    String getPhone();
}