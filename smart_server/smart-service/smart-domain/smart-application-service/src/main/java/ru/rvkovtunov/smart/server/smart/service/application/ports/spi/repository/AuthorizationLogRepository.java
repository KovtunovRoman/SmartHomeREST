package ru.rvkovtunov.smart.server.smart.service.application.ports.spi.repository;

import ru.rvkovtunov.smart.server.smart.service.domain.core.entity.dto.AuthorizationLog;

import java.util.List;

public interface AuthorizationLogRepository {
    List<AuthorizationLog> getAll();
}
