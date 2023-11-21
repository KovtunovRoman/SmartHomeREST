package ru.rvkovtunov.smart.server.smart.service.application.ports.spi.repository;

import ru.rvkovtunov.smart.server.smart.service.domain.core.entity.dto.AuthorizationCard;

import java.util.List;

public interface AuthorizationCardRepository {

    List<AuthorizationCard> getAll();
}
