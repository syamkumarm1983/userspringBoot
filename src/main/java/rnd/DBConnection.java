package rnd;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

import java.nio.file.Paths;

public class DBConnection {

    public static void main(String[] args) {
        // Create the CqlSession object:
        try (CqlSession session = CqlSession.builder()
                .withCloudSecureConnectBundle(Paths.get("/Users/syamkumarmamidipaka/Downloads/secure-connect-syam.zip"))
                .withAuthCredentials("dkgFHflnXdirMzNWItyifeMR","n+f5U9,-+gBKInjSWy.g1nZZf-gmytuigMdwt0Zs2u15DdgTRQfMpBaha0oQhCK0nQlbE19Ay_mCQZURN2wuBMGz,9EPcFRfDEzcaSsxLZR5bHwalaT16hwvPURFiHXC")
                .build()) {
            // Select the release_version from the system.local table:
            ResultSet rs = session.execute("select * from user.user");
            for (Row r : rs) {
                System.out.println(r.getInt("id") + " " + r.getString("lastname") + " " + r.getString("firstname") + " " + r.getString("email"));
            }
            session.close();
            System.exit(0);
        }
    }
}
