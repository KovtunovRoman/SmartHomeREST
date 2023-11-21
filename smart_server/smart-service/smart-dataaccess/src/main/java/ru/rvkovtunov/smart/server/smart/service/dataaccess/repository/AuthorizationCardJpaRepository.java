package ru.rvkovtunov.smart.server.smart.service.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rvkovtunov.smart.server.smart.service.dataaccess.entity.AuthorizationCardEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface AuthorizationCardJpaRepository extends JpaRepository<AuthorizationCardEntity, UUID> {

    @Query(value = """
            select e from AuthorizationCardEntity e
            """)
    List<AuthorizationCardEntity> getAll();
}
