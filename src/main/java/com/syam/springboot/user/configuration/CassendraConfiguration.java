package com.syam.springboot.user.configuration;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        Path bundle1 = this.getSecureConnectBundle().toPath();
        File f = new File(bundle1.toUri());
        return builder -> builder.withCloudSecureConnectBundle(bundle1)
                .withAuthCredentials(username,password)
                .withKeyspace(keyspacename);
    }

//    public static void main(String[] args) {
//        // Create the CqlSession object:
//        try (CqlSession session = CqlSession.builder()
//                .withCloudSecureConnectBundle(Paths.get("/Users/syamkumarmamidipaka/Learning/Java/userspringBoot/src/main/resources/secure-connect-user.zip"))
//                .withAuthCredentials("WduaZLNHhiTPdjZolYJodHat","v3wLjaFY+7WTNBI,Y_.HZLD+1+XiDyXGpbHBSd-Jn2ZKeJzt59h7OxvcF,nfn2QoFQfl5FkWZpnyORez+NOwNhc-c,TJg6pZmXFlPHZD0fmCk4gTFUevyyl5U5EQIfZB")
//                .build()) {
//            // Select the release_version from the system.local table:
//            ResultSet rs = session.execute("select release_version from system.local");
//            Row row = rs.one();
//            //Print the results of the CQL query to the console:
//            if (row != null) {
//                System.out.println(row.getString("release_version"));
//            } else {
//                System.out.println("An error occurred.");
//            }
//        }
//        System.exit(0);
//    }
}
