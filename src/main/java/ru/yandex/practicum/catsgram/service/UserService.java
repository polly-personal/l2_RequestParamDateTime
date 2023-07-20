package ru.yandex.practicum.catsgram.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.controller.PostController;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.model.User;

import java.util.*;

@Slf4j
@Data
@Service
public class UserService {
    private final Map<String, User> users = new HashMap<>();

    public Collection<User> findAll() {
        log.info("🟢 список пользователей выдан");
        return new ArrayList<>(users.values());
    }

    public User create(User user) throws InvalidEmailException, UserAlreadyExistException {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            log.warn("🔴 отсутствует адрес электронной почты");
            throw new InvalidEmailException("отсутствует адрес электронной почты");
        }

        if (users.containsKey(user.getEmail())) {
            log.warn("🟥 Пользователь с электронной почтой " +
                    user.getEmail() + " уже зарегистрирован.");
            throw new UserAlreadyExistException("Пользователь с электронной почтой " +
                    user.getEmail() + " уже зарегистрирован.");
        }

        users.put(user.getEmail(), user);
        log.info("🟢 пользователь добавлен");
        return user;
    }

    public User updateUser(User updatedUser) throws InvalidEmailException{
        if (updatedUser.getEmail() == null || updatedUser.getEmail().isBlank()) {
            log.warn("🔴 отсутствует адрес электронной почты");
            throw new InvalidEmailException("отсутствует адрес электронной почты");
        }

        if (users.containsKey(updatedUser.getEmail())) {
            users.put(updatedUser.getEmail(), updatedUser);
            log.info("🟢 пользователь обновлен");

            return updatedUser;
        }
        log.warn("🔴 пользователь НЕ обновлен");
        return null;
    }

    public User findUserByEmail(String email) {
        if (email == null) {
            log.warn("🔴 email НЕ найден");
            return null;
        }

        if (users.containsKey(email)) {
            log.info("🟢 email найден");
            return users.get(email);
        }

        log.warn("🔴 email НЕ найден");
        return null;
    }
}
