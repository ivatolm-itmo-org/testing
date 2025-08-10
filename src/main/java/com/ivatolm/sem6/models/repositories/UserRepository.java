package com.ivatolm.sem6.models.repositories;

import com.ivatolm.sem6.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
