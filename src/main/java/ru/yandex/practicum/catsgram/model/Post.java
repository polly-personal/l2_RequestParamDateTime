package ru.yandex.practicum.catsgram.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

//todo срабатывает @AllArgsConstructor при создании поста
@AllArgsConstructor
@Data
public class Post {
    private Integer id;
    private final String author;

    private final LocalDate creationDate; // date=yyyy-MM-dd
/*
    private final LocalDateTime creationDateTime; // date-time=yyyy-MM-dd HH:mm:ss
*/
/*
    private final LocalTime creationTime; // time=HH:mm:ss
*/


//    private final Instant creationDate;
//    private final Instant creationDate = Instant.now();
    private String description;
    private String photoUrl; // url-адрес фотографии

/*
    public Post(String author, String description, String photoUrl) {
        this.author = author;
        this.description = description;
        this.photoUrl = photoUrl;
    }
*/
}