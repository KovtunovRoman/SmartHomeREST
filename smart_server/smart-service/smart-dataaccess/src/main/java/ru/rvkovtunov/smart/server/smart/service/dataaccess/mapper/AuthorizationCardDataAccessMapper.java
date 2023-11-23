package ru.rvkovtunov.smart.server.smart.service.dataaccess.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.rvkovtunov.smart.server.smart.service.dataaccess.entity.AuthorizationCardEntity;
import ru.rvkovtunov.smart.server.smart.service.domain.core.entity.dto.AuthorizationCard;
import ru.rvkovtunov.smart.server.smart.service.domain.core.valueobject.AuthorizationCardId;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AuthorizationCardDataAccessMapper {

    @Mapping(source = "entity.id", target = "id", qualifiedByName = "id")
    AuthorizationCard toDomain (AuthorizationCardEntity entity);

    @Mapping(source = "domain.id", target = "id", qualifiedByName = "id")
    AuthorizationCardEntity toEntity (AuthorizationCard domain);

    @Named("id")
    default AuthorizationCardId getId(UUID id){
        return AuthorizationCardId.of(id);
    }

    @Named("id")
    default UUID getId(AuthorizationCardId id){
        return id.getValue();
    }
}
