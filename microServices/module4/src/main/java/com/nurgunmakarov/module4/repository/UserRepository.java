package com.nurgunmakarov.module4.repository;

import com.nurgunmakarov.module4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByName(String name);

}
