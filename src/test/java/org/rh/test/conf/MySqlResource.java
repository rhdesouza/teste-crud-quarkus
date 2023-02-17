package org.rh.test.conf;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.MySQLContainer;

import java.util.Collections;
import java.util.Map;

public class MySqlResource implements QuarkusTestResourceLifecycleManager {

    static MySQLContainer<?> db =
            new MySQLContainer<>("mysql:latest")
                    .withDatabaseName("myDB")
                    .withUsername("root")
                    .withPassword("root")
                    .withInitScript("init.sql");
      /*              .withClasspathResourceMapping("init.sql",
                            "/docker-entrypoint-initdb.d/init.sql",
                            BindMode.READ_WRITE);*/

    @Override
    public Map<String, String> start() {
        db.start();
        return Collections.singletonMap("quarkus.datasource.jdbc.url", db.getJdbcUrl());
    }

    @Override
    public void stop() {
        db.stop();
    }

/*    @Override
    public String getJdbcUrl() {
        return "jdbc:mysql://" + getContainerIpAddress() + ":" + getMappedPort(MYSQL_PORT) + "/" + databaseName;
    }*/
}
