package ru.yandex.practicum.catsgram.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

@Data
public class User {
    private String email;
    private String nickname;
    private LocalDate birthdate;

    public boolean equals(User user) {
        if (this == user) return true;
        if (user == null) return false;
        if (this.getClass() != user.getClass()) return false;

        User otherUser = (User) user;
        return Objects.equals(this.email, otherUser.email);
    }

    public int hashCode() {
        return Objects.hashCode(this.email);
    }
}