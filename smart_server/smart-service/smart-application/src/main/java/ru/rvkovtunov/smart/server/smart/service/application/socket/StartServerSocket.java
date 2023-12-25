package ru.rvkovtunov.smart.server.smart.service.application.socket;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartServerSocket implements RunSocket {

    private final SmartServerSocket serverSocket;

    @Override
    public void startSocketServer() {
        serverSocket.startProgram();
    }
}
