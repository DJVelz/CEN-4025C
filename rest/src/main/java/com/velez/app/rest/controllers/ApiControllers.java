package com.velez.app.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiControllers {

    @GetMapping(value = "/")
    public String hello() {
        return "Hello World";
    }
}
