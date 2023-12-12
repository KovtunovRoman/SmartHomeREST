package ru.rvkovtunov.smart.server.smart.service.application.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rvkovtunov.smart.server.smart.service.application.ports.api.AuthorizationCardService;
import ru.rvkovtunov.smart.server.smart.service.application.socket.SmartServerSocket;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthorizationCardController {

    private final AuthorizationCardService service;
    private final SmartServerSocket socket;

    @GetMapping("/listCards")
    public ResponseEntity<Object> getAllCards(){
        log.info("Получаем все карты из базы");
        final var response = service.getAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getBoolFromButton(@RequestParam Boolean bool){
        socket.sendDataToMicroProcessor(bool.toString());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
