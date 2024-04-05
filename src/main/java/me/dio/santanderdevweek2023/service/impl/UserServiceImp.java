package me.dio.santanderdevweek2023.service.impl;

import me.dio.santanderdevweek2023.entities.model.User;
import me.dio.santanderdevweek2023.repository.UserRepository;
import me.dio.santanderdevweek2023.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new IllegalArgumentException("This user already exists");
        }
        return userRepository.save(user);
    }
}
