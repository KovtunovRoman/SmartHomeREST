package ru.rvkovtunov.smart.server.smart.service.application.ports.api;

import ru.rvkovtunov.smart.server.smart.service.domain.core.entity.dto.AuthorizationLog;

import java.util.List;

public interface AuthorizationLogService {
    List<AuthorizationLog> getAll();
}
