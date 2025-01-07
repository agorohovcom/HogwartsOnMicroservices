package com.agorohov.hgwrts.studentmanagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

//    @Bean
//    RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

    @Bean
    WebClient webClient() {
        return WebClient.create();
    }
}
