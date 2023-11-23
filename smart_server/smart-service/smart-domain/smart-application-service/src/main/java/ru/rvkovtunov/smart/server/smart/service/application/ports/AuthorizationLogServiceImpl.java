package ru.rvkovtunov.smart.server.smart.service.application.ports;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rvkovtunov.smart.server.smart.service.application.ports.api.AuthorizationLogService;
import ru.rvkovtunov.smart.server.smart.service.application.ports.spi.repository.AuthorizationLogRepository;
import ru.rvkovtunov.smart.server.smart.service.domain.core.entity.dto.AuthorizationLog;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorizationLogServiceImpl implements AuthorizationLogService {
    private final AuthorizationLogRepository repository;
    @Override
    public List<AuthorizationLog> getAll() {
        return repository.getAll();
    }
}
