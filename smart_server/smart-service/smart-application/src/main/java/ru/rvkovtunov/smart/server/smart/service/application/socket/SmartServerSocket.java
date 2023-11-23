package ru.rvkovtunov.smart.server.smart.service.application.socket;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
@RequiredArgsConstructor
@Component
public class SmartServerSocket {
    private static Socket socket;
    private static ServerSocket serverSocket;
    private static BufferedReader reader;
    private static BufferedWriter writer;

    public Boolean sendDataToMicroProcessor(String message) {
        try {
            try {
                serverSocket = new ServerSocket(48669);
                log.info("Сокет-сервер запущен");

                socket = serverSocket.accept();
                if (socket.isBound() && !socket.isClosed()) {
                    log.info("Соединение установлено");
                    try {
                        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                        String request = reader.readLine();
                        System.out.println(request);

                        writer.write(message);
                        writer.flush();
                    } catch (IOException e) {
                        log.error("Ошибка чтения/записи в сокете: {}", e.getMessage());
                        return false;
                    } finally {
                        socket.close();
                        reader.close();
                        writer.close();
                    }
                } else log.info("Соединение не установлено");

            } finally {
                serverSocket.close();
            }
        } catch (IOException e) {
            log.error("Неудачное соединение с портом: {}", e.getMessage());
            return false;
        }
        return true;
    }
}
