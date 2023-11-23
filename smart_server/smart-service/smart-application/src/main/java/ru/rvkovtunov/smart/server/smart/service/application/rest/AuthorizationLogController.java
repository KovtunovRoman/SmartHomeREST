package ru.rvkovtunov.smart.server.smart.service.application.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rvkovtunov.smart.server.smart.service.application.ports.api.AuthorizationLogService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthorizationLogController {

    private final AuthorizationLogService service;

    @GetMapping("/listLogsCards")
    public ResponseEntity<Object> getAllCards(){
        log.info("Получаем все логи");
        final var response = service.getAll();
        return ResponseEntity.ok(response);
    }
}
