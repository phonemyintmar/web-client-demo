package com.pm.webclientdemo.controller;

import com.pm.webclientdemo.service.WebclientDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final WebclientDemoService service;

    public TestController(WebclientDemoService service) {
        this.service = service;
    }

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("test")
    public String test() {
        return service.test();
    }


}
