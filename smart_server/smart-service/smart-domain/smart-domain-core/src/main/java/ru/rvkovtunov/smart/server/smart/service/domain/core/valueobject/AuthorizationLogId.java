package ru.rvkovtunov.smart.server.smart.service.domain.core.valueobject;

import java.util.UUID;

public class AuthorizationLogId extends BaseId<UUID> {

    protected AuthorizationLogId(final UUID value) {
        super(value);
    }

    public static AuthorizationLogId newInstance() {
        return new AuthorizationLogId(UUID.randomUUID());
    }

    public static AuthorizationLogId of(final UUID value) {
        return new AuthorizationLogId(value);
    }
}
