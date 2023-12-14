package ru.rvkovtunov.smart.server.smart.service.application.socket;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

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

    @SneakyThrows
    public void startSocket(){
        System.out.println(Thread.currentThread().getName());
        setConnectionParams(4004);
        prolog();
        socket = serverSocket.accept();
        start();
    }

    @Async
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
        try {
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write(message);
            writer.flush();
        } catch (IOException e) {
            log.error("Ошибка записи в сокете: {}", e.getMessage());
        }
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
