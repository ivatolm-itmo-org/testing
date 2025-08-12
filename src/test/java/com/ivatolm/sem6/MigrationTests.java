package com.ivatolm.sem6;

import com.ivatolm.sem6.models.User;
import com.ivatolm.sem6.models.repositories.UserRepository;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class MigrationTests extends BaseIntegrationTests {

    private static final String LATEST_MIGRATION_VERSION = "2";
    private static final String TABLE_NAME = "users";

    @Autowired
    private UserRepository userRepository;

    @Override
    @BeforeEach
    void setup() {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("filesystem:src/test/resources/db/newmigration")
                .cleanDisabled(false)
                .target(LATEST_MIGRATION_VERSION)
                .load();
        flyway.clean();
        flyway.migrate();
    }

    void migrateTo(String version) {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("filesystem:src/test/resources/db/newmigration")
                .target(version)
                .load();
        flyway.migrate();
    }

    private boolean columnExists(String columnName) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            try (ResultSet columns = metaData.getColumns(null, null, MigrationTests.TABLE_NAME, columnName)) {
                return columns.next();
            }
        }
    }

    @Test
    void testV2ToV3DatabaseSchema() throws Exception {
        assertFalse(columnExists("age"));
        migrateTo("3");
        assertTrue(columnExists("age"));
    }

    @Test
    void testV2ToV3UserData() throws SQLException {
        final String newUserQuery = String.format("INSERT INTO %s (name,email) VALUES (?,?)", TABLE_NAME);
        final String selectUserQuery = String.format("SELECT * FROM %s WHERE name = ?", TABLE_NAME);

        final String user_name = "Bob Ross";
        final String user_email = "bobross@example.com";

        PreparedStatement newUserStatement = dataSource.getConnection().prepareStatement(newUserQuery);
        newUserStatement.setString(1, user_name);
        newUserStatement.setString(2, user_email);
        newUserStatement.execute();

        migrateTo("3");

        PreparedStatement selectUserStatement = dataSource.getConnection().prepareStatement(selectUserQuery);
        selectUserStatement.setString(1, user_name);
        selectUserStatement.execute();

        ResultSet resultSet = selectUserStatement.getResultSet();
        resultSet.next();

        Integer value = resultSet.getObject("age", Integer.class);
        assertNull(value);
    }

    @Test
    void testV3ToV4DatabaseSchema() throws Exception {
        migrateTo("3");
        assertTrue(columnExists("age"));
        migrateTo("4");
        assertFalse(columnExists("age"));
    }

    @Test
    void testV3ToV4UserData() throws SQLException {
        migrateTo("3");

        final String newUserQuery = String.format("INSERT INTO %s (name,email,age) VALUES (?,?,?)", TABLE_NAME);
        final String selectUserQuery = String.format("SELECT * FROM %s WHERE name = ?", TABLE_NAME);

        final String user_name = "Bob Ross";
        final String user_email = "bobross@example.com";
        final int user_age = 21;

        PreparedStatement newUserStatement = dataSource.getConnection().prepareStatement(newUserQuery);
        newUserStatement.setString(1, user_name);
        newUserStatement.setString(2, user_email);
        newUserStatement.setInt(3, user_age);
        newUserStatement.execute();

        migrateTo("4");

        PreparedStatement selectUserStatement = dataSource.getConnection().prepareStatement(selectUserQuery);
        selectUserStatement.setString(1, user_name);
        selectUserStatement.execute();

        ResultSet resultSet = selectUserStatement.getResultSet();
        resultSet.next();

        String migrated_user_name = resultSet.getObject("name", String.class);
        assertNotNull(migrated_user_name);

        String migrated_user_email = resultSet.getObject("email", String.class);
        assertNotNull(migrated_user_email);

        assertEquals(user_name, migrated_user_name);
        assertEquals(user_email, migrated_user_email);
    }

}
