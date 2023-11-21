package ru.rvkovtunov.smart.server.smart.service.domain.core.entity.dto;

import lombok.Getter;
import lombok.Setter;
import ru.rvkovtunov.smart.server.domain.entity.AggregateRoot;
import ru.rvkovtunov.smart.server.smart.service.domain.core.valueobject.AuthorizationCardId;

@Setter
@Getter
public class AuthorizationCard extends AggregateRoot<AuthorizationCardId> {
    private boolean allowed;
}
