package com.vlad.pp_311_3.repositories;

import com.vlad.pp_311_3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String username);
}
