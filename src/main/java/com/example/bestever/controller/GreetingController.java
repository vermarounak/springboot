package com.example.bestever.controller;

import com.example.bestever.domain.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    static final String GET_GREETING = "/greeting";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(GET_GREETING)
    public Greeting greet(
            @RequestParam(value = "name", defaultValue = "Spring") String name) {
        return new Greeting(counter.incrementAndGet(), String.format("Hello, %s", name));
    }
}
