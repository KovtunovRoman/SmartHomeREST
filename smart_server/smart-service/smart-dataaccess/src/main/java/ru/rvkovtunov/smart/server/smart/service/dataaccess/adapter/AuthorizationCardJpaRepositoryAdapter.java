package ru.rvkovtunov.smart.server.smart.service.dataaccess.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.rvkovtunov.smart.server.smart.service.application.ports.spi.repository.AuthorizationCardRepository;
import ru.rvkovtunov.smart.server.smart.service.dataaccess.mapper.AuthorizationCardDataAccessMapper;
import ru.rvkovtunov.smart.server.smart.service.dataaccess.repository.AuthorizationCardJpaRepository;
import ru.rvkovtunov.smart.server.smart.service.domain.core.entity.dto.AuthorizationCard;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorizationCardJpaRepositoryAdapter implements AuthorizationCardRepository {

    private final AuthorizationCardJpaRepository repository;
    private final AuthorizationCardDataAccessMapper mapper;

    @Override
    public List<AuthorizationCard> getAll() {
        return repository.getAll().stream().map(mapper::toDomain).toList();
    }
}
