package com.pm.webclientdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class WebclientDemoService {

    private final WebClient webClient;

    public WebclientDemoService(WebClient webClient) {
        this.webClient = webClient;
    }

    public String test() {
        String result = "Hello world \n";

        Mono<String> stringMono = webClient.get().uri("/ping").retrieve().bodyToMono(String.class);
//        webClient.get().uri("/test").retrieve().bodyToMono(String.class).block();
        String apiResponse = webClient.get()
                .uri("/ping")
                .retrieve()
                .bodyToMono(String.class).block();
        return result + apiResponse;
    }

}
