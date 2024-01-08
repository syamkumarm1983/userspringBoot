package com.syam.springboot.user.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.nio.file.Path;

@ConfigurationProperties(prefix = "datastax.astra")
@Getter
@Setter
@Configuration
public class CassendraConfiguration {
    private File secureConnectBundle;
    private String username;
    private String password;
    private String keyspacename;


    @Bean
    public CqlSessionBuilderCustomizer sessionBuilderCustomizer() {
        Path bundle = this.getSecureConnectBundle().toPath();
        return builder -> builder.withCloudSecureConnectBundle(bundle)
                .withAuthCredentials(username,password)
                .withKeyspace(keyspacename);
    }
}
