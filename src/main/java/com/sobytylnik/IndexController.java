package com.sobytylnik;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    private static final String HELLO = "Hello";

    @RequestMapping("/")
    public String index() {
        return HELLO;
    }
}
