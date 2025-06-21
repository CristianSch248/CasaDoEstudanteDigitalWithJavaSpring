package com.ceuDigital.api.repositories;

import com.ceuDigital.api.domain.usuario.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
