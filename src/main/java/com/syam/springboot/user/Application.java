package com.syam.springboot.user;

import com.syam.springboot.user.configuration.CassendraConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(CassendraConfiguration.class)
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
