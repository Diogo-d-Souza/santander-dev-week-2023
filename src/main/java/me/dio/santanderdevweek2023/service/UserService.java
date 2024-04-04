package me.dio.santanderdevweek2023.service;

import me.dio.santanderdevweek2023.entities.model.User;

import java.util.UUID;

public interface UserService {
    User findById (UUID id);

    User create (User user);
}
