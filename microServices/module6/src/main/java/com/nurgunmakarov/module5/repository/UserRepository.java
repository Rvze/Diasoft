package com.nurgunmakarov.module5.repository;

import com.nurgunmakarov.module5.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByName(String name);

}
