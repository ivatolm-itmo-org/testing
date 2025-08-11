package com.ivatolm.sem6.models.repositories;

import com.ivatolm.sem6.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    List<User> findAll();

    User findByEmail(String mail);

}
