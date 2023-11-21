package ru.rvkovtunov.smart.server.smart.service.application.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rvkovtunov.smart.server.smart.service.application.ports.api.AuthorizationCardService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthorizationCardController {

    private final AuthorizationCardService service;

    @GetMapping("/listCards")
    public ResponseEntity<Object> getAllCards(){
        log.info("Получаем все карты");
        final var response = service.getAll();
        return ResponseEntity.ok(response);
    }
}
