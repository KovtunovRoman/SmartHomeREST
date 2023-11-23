package ru.rvkovtunov.smart.server.smart.service.domain.core.entity.dto;

import lombok.Getter;
import lombok.Setter;
import ru.rvkovtunov.smart.server.domain.entity.AggregateRoot;
import ru.rvkovtunov.smart.server.smart.service.domain.core.valueobject.AuthorizationLogId;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class AuthorizationLog extends AggregateRoot<AuthorizationLogId> {
    private UUID authorizationCardId;
    private LocalDateTime dateTime;
    private boolean allowed;
}
