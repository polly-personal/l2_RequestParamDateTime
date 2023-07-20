package ru.yandex.practicum.catsgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.Config.DateTimeConfig;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.service.PostService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class PostController {
    private final PostService postService;

    private DateTimeConfig dateTimeConfig = new DateTimeConfig();

/*
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
*/

    @Autowired
    public PostController(PostService postService, DateTimeConfig dateTimeConfig) {
        this.postService = postService;
        this.dateTimeConfig = dateTimeConfig;
    }
//------------------------------------------------------------------------------------------------

    /* СОЗДАНИЕ */
    @PostMapping("/posts/post")
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    /* ВЫДАЧА ВСЕХ ПО author и date ПАРАМЕТРАМ (ЧЕРЕЗ pattern) //todo работает ОК */
    // ожидается posts/post/search?author=email@yandex.com&date=1945-01-12
/*
    @GetMapping("posts/post/search")
    public List<Post> findAllByAuthorAndDateParametersWithPattern(
            @RequestParam String author,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date
    ) {
        System.out.println("Ищем посты пользователя с именем " + author + " и опубликованные " + date);
        return postService.findPostsByAuthorAndDate(author, date);
    }
*/

    /* ВЫДАЧА ВСЕХ ПО author и date ПАРАМЕТРАМ (ЧЕРЕЗ iso) //todo работает ОК*/
    // ожидается posts/post/search?author=email@yandex.com&date=1945-01-12
/*
    @GetMapping("posts/post/search")
    public List<Post> findAllByAuthorAndDateParametersWithIso(
            @RequestParam String author,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        System.out.println("Ищем посты пользователя с именем " + author + " и опубликованные " + date);
        return postService.findPostsByAuthorAndDate(author, date);
    }
*/


//todo application.properties: https://www.baeldung.com/spring-date-parameters#applicationProperties

    /* date=yyyy-MM-dd //todo работает ОК*/
    /* ВЫДАЧА ВСЕХ ПО author и date ПАРАМЕТРАМ (ЧЕРЕЗ application.properties)*/
    // ожидается posts/post/search?author=email@yandex.com&date=1945-01-12
/*
    @GetMapping("posts/post/search")
    public List<Post> findAllByAuthorAndDateParametersWithApplicationProperties(
            @RequestParam String author,
            @RequestParam LocalDate date
    ) {
        System.out.println("Ищем посты пользователя с именем " + author + " и опубликованные " + date);
        return postService.findPostsByAuthorAndDate(author, date);
    }
*/

    /* date-time=yyyy-MM-dd HH:mm:ss //todo работает ОК*/
    /* ВЫДАЧА ВСЕХ ПО author и dateTime ПАРАМЕТРАМ (ЧЕРЕЗ application.properties)*/
    // ожидается posts/post/search?author=email@yandex.com&date=1945-01-12 16:24:50
/*
    @GetMapping("posts/post/search")
    public List<Post> findAllByAuthorAndDateParametersWithApplicationProperties(
            @RequestParam String author,
            @RequestParam LocalDateTime date
    ) {
        System.out.println("Ищем посты пользователя с именем " + author + " и опубликованные " + date);
        return postService.findPostsByAuthorAndDateTime(author, date);
    }
*/

    /* time=HH:mm:ss //todo работает ОК*/
    /* ВЫДАЧА ВСЕХ ПО author и date ПАРАМЕТРАМ (ЧЕРЕЗ application.properties)*/
    // ожидается posts/post/search?author=email@yandex.com&date=16:24:00
/*
    @GetMapping("posts/post/search")
    public List<Post> findAllByAuthorAndDateParametersWithApplicationProperties(
            @RequestParam String author,
            @RequestParam LocalTime date
    ) {
        System.out.println("Ищем посты пользователя с именем " + author + " и опубликованные " + date);
        return postService.findPostsByAuthorAndTime(author, date);
    }
*/

    /* date-time=iso //todo работает ОК*/
    /* ВЫДАЧА ВСЕХ ПО author и date ПАРАМЕТРАМ (ЧЕРЕЗ application.properties)*/
    // ожидается posts/post/search?author=email@yandex.com&date=1945-01-12T16:24:50
/*
    @GetMapping("posts/post/search")
    public List<Post> findAllByAuthorAndDateParametersWithApplicationProperties(
            @RequestParam String author,
            @RequestParam LocalDateTime date
    ) {
        System.out.println("Ищем посты пользователя с именем " + author + " и опубликованные " + date);
        return postService.findPostsByAuthorAndDateTime(author, date);
    }
*/


//-------------------------------------------------------------------------------------------------------
    /* //todo НЕ РАБОТАЕТ: ВЫДАЧА ВСЕХ ПО author и date ПАРАМЕТРАМ (ЧЕРЕЗ DateTimeConfig.class)*/
    // ожидается posts/post/search?author=email@yandex.com&date=1945-01-12
    @GetMapping("posts/post/search")
    public List<Post> findAllByAuthorAndDateParametersWithDateTimeConfig(
            @RequestParam String author,
            @RequestParam @DateTimeFormat(value = dateTimeConfig) LocalDate date
    ) {
        System.out.println("Ищем посты пользователя с именем " + author + " и опубликованные " + date);
        return postService.findPostsByAuthorAndDate(author, date);
    }

}