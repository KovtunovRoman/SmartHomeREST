package ru.rvkovtunov.smart.server.smart.service.dataaccess.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.rvkovtunov.smart.server.smart.service.dataaccess.entity.AuthorizationLogEntity;
import ru.rvkovtunov.smart.server.smart.service.domain.core.entity.dto.AuthorizationLog;
import ru.rvkovtunov.smart.server.smart.service.domain.core.valueobject.AuthorizationLogId;

import java.util.UUID;

@Mapper(componentModel = "spring"/*, uses = {AuthorizationCardDataAccessMapper.class}*/)
public interface AuthorizationLogDataAccessMapper {
    @Mapping(source = "entity.id", target = "id", qualifiedByName = "id")
    @Mapping(target = "authorizationCardId", source = "entity.authorizationCardId.id")
    AuthorizationLog toDomain(AuthorizationLogEntity entity);

    @Mapping(source = "domain.id", target = "id", qualifiedByName = "id")
    @Mapping(target = "authorizationCardId.id", source = "domain.authorizationCardId")
    AuthorizationLogEntity toEntity(AuthorizationLog domain);

    @Named("id")
    default AuthorizationLogId getId(UUID id) {
        return AuthorizationLogId.of(id);
    }

    @Named("id")
    default UUID getId(AuthorizationLogId id) {
        return id.getValue();
    }
}
