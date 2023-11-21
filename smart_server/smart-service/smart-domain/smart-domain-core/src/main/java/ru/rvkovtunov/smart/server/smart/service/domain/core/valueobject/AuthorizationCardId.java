package ru.rvkovtunov.smart.server.smart.service.domain.core.valueobject;

import java.util.UUID;

public class AuthorizationCardId extends BaseId<UUID>{

    protected AuthorizationCardId(final UUID value){
        super(value);
    }

    public static AuthorizationCardId newInstance(){
        return new AuthorizationCardId(UUID.randomUUID());
    }

    public static AuthorizationCardId of(final UUID value){
        return new AuthorizationCardId(value);
    }
}
