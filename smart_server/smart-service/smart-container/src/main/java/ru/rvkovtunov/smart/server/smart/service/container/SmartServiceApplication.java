package ru.rvkovtunov.smart.server.smart.service.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.rvkovtunov.smart.server.smart.service.application.socket.RunSocket;

@SpringBootApplication(scanBasePackages = "ru.rvkovtunov.smart.server")
@EnableJpaRepositories(basePackages = {"ru.rvkovtunov.smart.server.smart.service.dataaccess"})
@EntityScan(basePackages = {"ru.rvkovtunov.smart.server.smart.service.dataaccess"})
public class SmartServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SmartServiceApplication.class, args);
        context.getBean(RunSocket.class).startSocketServer();
    }
}

