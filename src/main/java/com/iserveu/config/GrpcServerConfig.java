package com.iserveu.config;


import com.iserveu.controller.AepsAxisController;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.concurrent.Executors;

@CommonsLog
@Component
public class GrpcServerConfig implements InitializingBean {

    @Autowired
    AepsAxisController axisController;

    Server server;
    @Override
    public void afterPropertiesSet() throws Exception {

        server = ServerBuilder.forPort(9097).executor(Executors.newFixedThreadPool(50))
                .addService(axisController).build();
        log.info("Grpc Server Server data  :"+server);
        try {
            server.start();
            System.out.println("Server started on port " + server.getPort());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void onExit() {
        System.out.println("onExit() Shutting down server...");
        Server server = this.server.shutdown();
        System.out.println("onExit() Server termination status: " + server.isTerminated());
        System.out.println("onExit() Server shutdown status: " + server.isShutdown());
    }
}
