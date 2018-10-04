package org.radekbor.zipkingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkingServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkingServerApplication.class, args);
    }
}
