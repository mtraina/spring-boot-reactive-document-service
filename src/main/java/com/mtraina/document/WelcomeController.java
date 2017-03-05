package com.mtraina.document;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @GetMapping("/")
    public String welcome(){
        //logger.info("called");
        return "hello!";
    }

    @GetMapping("/{name}")
    public String welcome(@PathVariable String name){
        return "hello " + name + "!";
    }
}
