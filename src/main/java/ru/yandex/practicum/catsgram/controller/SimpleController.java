package ru.yandex.practicum.catsgram.controller;

//import ch.qos.logback.classic.Level;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

// создаём логер
//private static final Logger log = LoggerFactory.getLogger(SimpleController.class);

    @GetMapping("/home")
    public String homePage() {
        // логируем факт получения запроса
//        log.info("получен запрос");
//        ch.qos.logback.classic.Logger logLogback = (ch.qos.logback.classic.Logger) log;
//        logLogback.setLevel(Level.DEBUG);
//        log.debug("получен запрос GET /home");

        // возвращаем ответ в виде строки
        return "Котограм";
    }
}
