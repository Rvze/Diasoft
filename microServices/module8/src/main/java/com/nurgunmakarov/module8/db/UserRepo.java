package com.nurgunmakarov.module8.db;

import com.nurgunmakarov.module8.domain.Role;
import com.nurgunmakarov.module8.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class UserRepo {
    private final List<User> list = Arrays.asList(
            new User("Nurgun", new BCryptPasswordEncoder().encode("password"), Collections.singletonList(Role.USER)),
            new User("Max", new BCryptPasswordEncoder().encode("1234"), Collections.singletonList(Role.USER)),
            new User("Kolyan", new BCryptPasswordEncoder().encode("321"), Collections.singletonList(Role.USER))
    );

    public User findByName(String name) {
        return list.stream().filter(user -> user.getUsername().equals(name)).findFirst().get();
    }
}
