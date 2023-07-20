package ru.yandex.practicum.catsgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;
import ru.yandex.practicum.catsgram.service.UserService;

import java.util.Collection;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /* ВЫДАЧА ВСЕХ */
/*
    @GetMapping("/users")
    public Collection<User> findAll() {
        return userService.findAll();
    }
*/

    /* СОЗДАНИЕ */
    @PostMapping("/users/user")
    public User create(@RequestBody User user) throws UserAlreadyExistException, InvalidEmailException {
        return userService.create(user);
    }

    /* ОБНОВЛЕНИЕ по email (ЧЕРЕЗ ТЕЛО ЗАПРОСА)*/
    @PutMapping("/users/user")
    public User updateByEmailViaBody(@RequestBody User user) throws UserAlreadyExistException, InvalidEmailException {
        return userService.updateUser(user);
    }

    /* ВЫДАЧА ВСЕХ / ОДНОГО ПО id (ЧЕРЕЗ ПЕРЕМЕННУЮ ПУТИ)*/
    @GetMapping(value = {"/users", "/users/user/{email}"})
    public String findAllOrOneByEmailVariable(@PathVariable Optional<String> email) {
        if (email.isPresent()) {
            userService.findUserByEmail(email.get()).toString();
        }
        return userService.findAll().toString();
    }
}
