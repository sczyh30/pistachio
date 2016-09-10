package org.samsara.pistachio.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Service discovery component for Samsara Pistachio.
 * We use Netflix Eureka as the discovery infrastructure.
 *
 * @author Eric Zhao
 */
@SpringBootApplication
@EnableEurekaServer
public class PistachioDiscovery {

    public static void main(String[] args) {
        SpringApplication.run(PistachioDiscovery.class, args);
    }
}
