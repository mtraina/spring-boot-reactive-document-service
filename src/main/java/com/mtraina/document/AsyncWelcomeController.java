package com.mtraina.document;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@RestController
@RequestMapping("/async")
public class AsyncWelcomeController {
    private static final Logger logger = LoggerFactory.getLogger(AsyncWelcomeController.class);

    @GetMapping("/")
    public Mono<String> welcome() {
        return Mono.fromFuture(CompletableFuture.supplyAsync(s));
    }

    @GetMapping("/{name}")
    public Mono<String> welcome(@PathVariable String name){
        return Mono.just("hello " + name + "!");
    }

    private static final Supplier<String> s = () -> {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello!";
    };
}
