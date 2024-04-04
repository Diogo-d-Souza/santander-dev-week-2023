package me.dio.santanderdevweek2023.service.impl;

import me.dio.santanderdevweek2023.entities.model.User;
import me.dio.santanderdevweek2023.repository.UserRepository;
import me.dio.santanderdevweek2023.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.NoSuchElementException;
import java.util.UUID;

public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if (user.getId() != null && userRepository.existsById(user.getId())) {
            throw new IllegalArgumentException("This user already exists");
        }
        return userRepository.save(user);
    }
}