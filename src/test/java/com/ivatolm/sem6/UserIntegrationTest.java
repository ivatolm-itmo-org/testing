package com.ivatolm.sem6;

import com.ivatolm.sem6.models.User;
import com.ivatolm.sem6.models.repositories.UserRepository;
import com.ivatolm.sem6.services.UserService;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Flyway flyway;

    @Test
    void testCreateUser() {
        User created = userService.createUser("Bob", "bob@test.com");

        Optional<User> found = userRepository.findById(created.getId());
        assertTrue(found.isPresent());
        assertEquals("Bob", found.get().getName());
        assertEquals("bob@test.com", found.get().getEmail());
    }

    @Test
    void testUpdateUser() {
        User user = userService.createUser("Bob", "bob@test.com");

        user.setEmail("new.alice@test.com");
        userService.updateUser(user);

        Optional<User> updated = userRepository.findById(user.getId());
        assertTrue(updated.isPresent());
        assertEquals("new.alice@test.com", updated.get().getEmail());
    }

    @Test
    void testDeleteUser() {
        User user = userService.createUser("Bob", "bob@test.com");

        userService.deleteUser(user.getId());

        Optional<User> deleted = userRepository.findById(user.getId());
        assertTrue(deleted.isEmpty());
    }

}
