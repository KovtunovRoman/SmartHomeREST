package ru.rvkovtunov.smart.server.smart.service.application.socket;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;

@Slf4j
@RequiredArgsConstructor
@Component
@AllArgsConstructor
public class SmartServerSocket{
    private static Socket socket;
    private static BufferedWriter writer;
    private String m_ip;
    private int m_port;
    private boolean isStarted;

    @Async
    public void startSocketThread() {
        setConnectionParams("localhost", 4004);
        prolog();
        start();
        loop();
        stop();
        epilog();
    }

    public void start() {
        isStarted = true;
    }

    public void stop() {
        isStarted = false;
    }

    public void setConnectionParams(String ip, int port) {
        m_ip = ip;
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

    public void readDataFromMicroProcessor() {
        try {
            socket.setSoTimeout(500);
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
        connectToSocket(m_ip, m_port);
    }

    private void epilog() {
        try {
            socket.close();
        } catch (IOException e) {
            log.error("Ошибка закрытия сокета: {}", e);
        }
    }

    private static Boolean connectToSocket(String ip, int port) {
        try {
            socket = new Socket(ip, port);
            log.info("Соединение установлено");
            return true;
        } catch (IOException e) {
            log.error("{}", e);
            return false;
        }
    }
}
