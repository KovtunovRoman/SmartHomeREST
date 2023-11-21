package ru.rvkovtunov.smart.server.smart.service.application.ports.api;

import ru.rvkovtunov.smart.server.smart.service.domain.core.entity.dto.AuthorizationCard;

import java.util.List;

public interface AuthorizationCardService {
    List<AuthorizationCard> getAll();
}
