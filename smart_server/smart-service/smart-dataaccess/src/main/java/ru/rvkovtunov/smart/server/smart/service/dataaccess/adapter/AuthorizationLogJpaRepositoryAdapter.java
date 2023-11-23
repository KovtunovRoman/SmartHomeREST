package ru.rvkovtunov.smart.server.smart.service.dataaccess.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.rvkovtunov.smart.server.smart.service.application.ports.spi.repository.AuthorizationLogRepository;
import ru.rvkovtunov.smart.server.smart.service.dataaccess.mapper.AuthorizationLogDataAccessMapper;
import ru.rvkovtunov.smart.server.smart.service.dataaccess.repository.AuthorizationLogJpaRepository;
import ru.rvkovtunov.smart.server.smart.service.domain.core.entity.dto.AuthorizationLog;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorizationLogJpaRepositoryAdapter implements AuthorizationLogRepository {

    private final AuthorizationLogJpaRepository repository;
    private final AuthorizationLogDataAccessMapper mapper;

    public List<AuthorizationLog> getAll(){
        return repository.getAll().stream().map(mapper::toDomain).toList();
    }
}
