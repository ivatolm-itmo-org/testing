package com.ivatolm.sem6.models.repositories;

import com.ivatolm.sem6.models.User;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
