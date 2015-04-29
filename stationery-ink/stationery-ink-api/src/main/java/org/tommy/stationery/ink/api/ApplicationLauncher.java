package org.tommy.stationery.ink.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kun7788 on 15. 1. 28..
 */

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class ApplicationLauncher {
    public static void main(String[] args) {
        SpringApplication.run(RestApplicationConfig.class, args);
    }
}
