package com.ivatolm.sem6;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationVersion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = { "spring.flyway.enabled=false" })
public class MigrationCompatibilityTest extends BaseIntegrationTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testRollbackCompatibility() throws Exception {
        applyV1AndAddData();
        applyV2AndModifyData();
        applyV3AndVerify();
    }

    private void applyV1AndAddData() {
        Flyway flywayV1 = Flyway.configure()
                .dataSource(dataSource)
                .target(MigrationVersion.fromVersion("1"))
                .locations("classpath:db/migration")
                .load();

        flywayV1.migrate();

        jdbcTemplate.update("INSERT INTO users (name) VALUES ('Bob')");
        List<Map<String, Object>> users = jdbcTemplate.queryForList("SELECT * FROM users");
        assertEquals(1, users.size());
    }

    private void applyV2AndModifyData() throws Exception {
        Flyway flywayV2 = Flyway.configure()
                .dataSource(dataSource)
                .target(MigrationVersion.fromVersion("2"))
                .locations("classpath:db/migration")
                .load();

        flywayV2.migrate();

        assertTrue(columnExists("email"));
        jdbcTemplate.update("UPDATE users SET email = 'bob@example.com' WHERE name = 'Bob'");
    }

    private void applyV3AndVerify() throws Exception {
        Flyway flywayV1 = Flyway.configure()
                .dataSource(dataSource)
                .target(MigrationVersion.fromVersion("3"))
                .locations("classpath:db/migration")
                .load();

        flywayV1.migrate();

        assertFalse(columnExists("email"));
        List<Map<String, Object>> users = jdbcTemplate.queryForList("SELECT * FROM users");
        assertEquals(1, users.size());
        assertEquals("Bob", users.get(0).get("name"));
    }

    private boolean columnExists(String columnName) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            try (ResultSet columns = metaData.getColumns(null, null, "users", columnName)) {
                return columns.next();
            }
        }
    }

}
