package ru.rvkovtunov.smart.server.smart.service.application.ports;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rvkovtunov.smart.server.smart.service.application.ports.api.AuthorizationCardService;
import ru.rvkovtunov.smart.server.smart.service.application.ports.spi.repository.AuthorizationCardRepository;
import ru.rvkovtunov.smart.server.smart.service.domain.core.entity.dto.AuthorizationCard;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorizationCardServiceImpl implements AuthorizationCardService {

    private final AuthorizationCardRepository repository;

    @Override
    public List<AuthorizationCard> getAll() {
        return repository.getAll();
    }
}
