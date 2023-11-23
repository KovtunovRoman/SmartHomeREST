package ru.rvkovtunov.smart.server.smart.service.dataaccess.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authorization_card", schema = "public")
public class AuthorizationCardEntity extends BaseFields{

    @OneToMany(mappedBy = "authorizationCardId")
    private List<AuthorizationLogEntity> authorizationLogEntityList;

    @Column(name = "is_allowed")
    private boolean allowed;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorizationCardEntity that = (AuthorizationCardEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
