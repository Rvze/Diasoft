package com.nurgunmakarov.module5.service;

import com.nurgunmakarov.module5.entity.User;
import com.nurgunmakarov.module5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Transactional

    public User getUser(User user) {
        return userRepository.getUserByName(user.getName());
    }

    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public User update(User user, Long id) {
        Optional<User> users = userRepository.findById(id);
        if (users.isPresent()) {
            user.setId(id);
            userRepository.save(user);
            return user;
        } else
            return null;
    }

    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
