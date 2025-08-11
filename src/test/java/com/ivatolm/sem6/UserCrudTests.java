package com.ivatolm.sem6;

import com.ivatolm.sem6.models.User;
import com.ivatolm.sem6.models.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class UserCrudTests extends BaseIntegrationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testCreateUser() {
        User newUser = new User();
        newUser.setName("Bob Ross");
        newUser.setEmail("bobross@example.com");

        User savedUser = userRepository.save(newUser);

        assertNotNull(savedUser.getId());
        assertEquals("Bob Ross", savedUser.getName());
        assertEquals("bobross@example.com", savedUser.getEmail());
    }

    @Test
    void testReadUser() {
        User newUser = new User();
        newUser.setName("Bob Ross");
        newUser.setEmail("bobross@example.com");
        User savedUser = userRepository.save(newUser);

        User foundUser = userRepository.findById(savedUser.getId()).orElse(null);

        assertNotNull(foundUser);
        assertEquals(savedUser.getId(), foundUser.getId());
        assertEquals("Bob Ross", foundUser.getName());
    }

    @Test
    void testUpdateUser() {
        User newUser = new User();
        newUser.setName("Bob Ross");
        newUser.setEmail("bobross@example.com");
        User savedUser = userRepository.save(newUser);

        savedUser.setName("Alice Ross");
        userRepository.save(savedUser);

        User retrievedUser = userRepository.findById(savedUser.getId()).orElse(null);
        assertNotNull(retrievedUser);
        assertEquals("Alice Ross", retrievedUser.getName());
        assertEquals("bobross@example.com", retrievedUser.getEmail());
    }

    @Test
    void testDeleteUser() {
        User newUser = new User();
        newUser.setName("Bob Ross");
        newUser.setEmail("bobross@example.com");
        User savedUser = userRepository.save(newUser);

        userRepository.deleteById(savedUser.getId());

        assertFalse(userRepository.existsById(savedUser.getId()));
    }

    @Test
    void testFindAllUsers() {
        userRepository.deleteAll();

        userRepository.save(new User("Bob Ross", "bobross@example.com"));
        userRepository.save(new User("Alice Ross", "aliceross@example.com"));

        assertEquals(2, userRepository.findAll().size());
    }

    @Test
    void testFindByEmail() {
        userRepository.save(new User("Bob Ross", "bobross@example.com"));

        User found = userRepository.findByEmail("bobross@example.com");

        assertNotNull(found);
        assertEquals("Bob Ross", found.getName());
    }

    @Test
    void testEntityNotFound() {
        assertTrue(userRepository.findById(999L).isEmpty());
    }

}
