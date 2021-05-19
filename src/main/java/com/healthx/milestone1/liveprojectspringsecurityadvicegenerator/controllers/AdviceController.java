/*
 * Copyright (C) 2021 Aptly GmbH
 */

package com.healthx.milestone1.liveprojectspringsecurityadvicegenerator.controllers;

import com.healthx.milestone1.liveprojectspringsecurityadvicegenerator.config.TokenManager;
import com.healthx.milestone1.liveprojectspringsecurityadvicegenerator.model.Metric;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

/**
 * @author jose
 */

@RestController
public class AdviceController {

    @Value("${gateway.url}")
    private String gatewayUrl;

    private final TokenManager tokenManager;

    private final RestTemplate restTemplate;

    public AdviceController(TokenManager tokenManager, RestTemplate restTemplate) {
        this.tokenManager = tokenManager;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/advice")
    public ResponseEntity<Metric[]> advice() {
        String accessToken = tokenManager.getAccessToken();
        String url = gatewayUrl + "/metric";

        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION, "Bearer " + accessToken);

        return restTemplate.exchange(
                url, HttpMethod.GET, new HttpEntity<Object>(headers),
                Metric[].class);
    }
}
