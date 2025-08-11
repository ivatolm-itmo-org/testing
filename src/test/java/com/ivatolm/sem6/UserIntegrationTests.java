package com.ivatolm.sem6;

import com.ivatolm.sem6.models.User;
import com.ivatolm.sem6.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserIntegrationTests extends BaseIntegrationTests {

    @Autowired
    private UserService userService;

    @Test
    void testCreateUser() {
        User created = userService.createUser("Bob Ross", "bobross@example.com");

        Optional<User> found = userService.getUserById(created.getId());
        assertTrue(found.isPresent());
        assertEquals("Bob Ross", found.get().getName());
        assertEquals("bobross@example.com", found.get().getEmail());
    }

    @Test
    void testUpdateUser() {
        User user = userService.createUser("Bob Ross", "bobross@example.com");

        user.setEmail("aliceross@example.com");
        userService.updateUser(user);

        Optional<User> updated = userService.getUserById(user.getId());
        assertTrue(updated.isPresent());
        assertEquals("aliceross@example.com", updated.get().getEmail());
    }

    @Test
    void testDeleteUser() {
        User user = userService.createUser("Bob Ross", "bobross@example.com");

        userService.deleteUser(user.getId());

        Optional<User> deleted = userService.getUserById(user.getId());
        assertTrue(deleted.isEmpty());
    }

}
