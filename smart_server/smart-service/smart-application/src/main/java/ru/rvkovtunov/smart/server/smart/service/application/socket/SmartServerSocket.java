package ru.rvkovtunov.smart.server.smart.service.application.socket;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@RequiredArgsConstructor
@Component
@AllArgsConstructor
public class SmartServerSocket {
    private static Socket socket;
    private static ServerSocket serverSocket;
    private static BufferedWriter writer;
    private int m_port;
    private boolean isStarted;

    private ExecutorService executor = Executors.newCachedThreadPool();

    public void startProgram() {
        CompletableFuture.runAsync(this::startSocket, executor).thenRunAsync(this::startSocketThread, executor);
    }

    @SneakyThrows
    public void startSocket() {
        setConnectionParams(4004);
        prolog();
        start();
        socket = serverSocket.accept();
    }

    public void startSocketThread() {
        loop();
        stop();
        epilog();
    }

    private void start() {
        isStarted = true;
    }

    private void stop() {
        isStarted = false;
    }

    private void setConnectionParams(int port) {
        m_port = port;
    }

    public void sendDataToMicroProcessor(String message) {
        CompletableFuture.runAsync(() -> {
            try {
                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                writer.write(message);
                writer.flush();
            } catch (IOException e) {
                log.error("Ошибка записи в сокете: {}", e.getMessage());
            }
        }, executor);
    }

    private void readDataFromMicroProcessor() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line + "\n");
            }
        } catch (IOException e) {
            log.error("Ошибка чтения в сокете: {}", e.getMessage());
        }
    }

    private void loop() {
        while (isStarted) {
            readDataFromMicroProcessor();
        }
    }

    private void prolog() {
        openSocket(m_port);
    }

    private void epilog() {
        try {
            serverSocket.close();
            socket.close();
            log.info("Сокет успешно закрыт");
        } catch (IOException e) {
            log.error("Ошибка закрытия сокета: {}", e);
        }
    }

    private void openSocket(int port) {
        try {
            serverSocket = new ServerSocket(port);
            log.info("Сокет запущен");
        } catch (IOException e) {
            log.error("Ошибка запуска сокета: {}", e);
        }
    }
}
