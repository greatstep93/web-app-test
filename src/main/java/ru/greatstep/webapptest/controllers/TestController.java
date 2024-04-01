package ru.greatstep.webapptest.controllers;

import java.util.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final Logger logger = Logger.getLogger("TEST");

    private static final String RESPONSE = "ok";

    @GetMapping("/test")
    public String test() throws InterruptedException {
        logger.info(Thread.currentThread().toString());
        Thread.sleep(1000);
        return RESPONSE;
    }

}
