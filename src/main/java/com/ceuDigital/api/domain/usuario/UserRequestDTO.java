package com.ceuDigital.api.domain.usuario;

public record UserRequestDTO(String name,
                             String email,
                             String password,
                             Integer type,
                             String phone_number )
{ }
