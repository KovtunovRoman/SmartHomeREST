package ru.rvkovtunov.smart.server.smart.service.dataaccess.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "authorization_log", schema = "public")
public class AuthorizationLogEntity extends BaseFields{
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private AuthorizationCardEntity authorizationCardId;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "is_allowed")
    private boolean allowed;
}
