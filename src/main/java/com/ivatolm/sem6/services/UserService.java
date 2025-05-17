package com.ivatolm.sem6.services;

import com.ivatolm.sem6.models.User;
import com.ivatolm.sem6.models.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User createUser(String name, String email) {
        User user = new User(null, name, email);
        return repo.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return repo.findById(id);
    }

    public void updateUser(User user) {
        repo.save(user);
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }

}
