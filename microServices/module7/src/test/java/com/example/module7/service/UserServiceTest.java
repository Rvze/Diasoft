package com.example.module7.service;

import com.example.module7.entity.User;
import com.example.module7.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {
    static class UserServiceTestConfiguration {

        @Bean
        public UserService userService(UserRepository userRepository) {
            return new UserService(userRepository);
        }
    }

    @Autowired
    private UserService userService;


    @Test
    public void createUserTest() {
        User user = new User();
        user.setName("NUrgun");
        user.setSecondName("Makarov");
        userService.createUser(user);
        Long id = user.getId();
        User found = userService.findById(id);
        assertNotNull(found);
    }

    @Test
    public void updateUserTest() {
        User user = new User();
        user.setName("One");
        user.setSecondName("Two");
        userService.createUser(user);

        User newUser = new User();
        newUser.setName("Three");
        newUser.setSecondName("Four");
        Long id = user.getId();
        userService.update(newUser, id);

        User found = userService.findById(id);
        assertNotNull(found.getName(), "update user test");
    }

    @Test
    public void deleteUserTest(){
        User user = new User();
        user.setName("One");
        user.setSecondName("Two");
        userService.createUser(user);
        Long id = user.getId();
        userService.delete(id);

        assertNull(userService.findById(id));
    }

}