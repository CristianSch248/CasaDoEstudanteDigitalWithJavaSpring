package com.ceuDigital.api.repositories;

import com.ceuDigital.api.domain.user.SimpleUserProjection;
import com.ceuDigital.api.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID>
{
    Optional<SimpleUserProjection> findProjectedById(UUID id);
    List<SimpleUserProjection> findAllByIdIn(List<UUID> ids);
}
