package com.nhnacademy.accountapi.service;

import com.nhnacademy.accountapi.dto.LoginRequest;
import com.nhnacademy.accountapi.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {
    private final RestTemplate restTemplate;
    private final String shoppingMallLoginUrl;

    @Autowired
    public LoginService(RestTemplate restTemplate,
                        @Value("${shoppingmall.api.uri}/login")String shoppingMallLoginUrl) {
        this.restTemplate = restTemplate;
        this.shoppingMallLoginUrl = shoppingMallLoginUrl;
    }

    public UserResponse doLogin(LoginRequest loginRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<LoginRequest> request = new HttpEntity<>(loginRequest, headers);

        return restTemplate.postForObject(shoppingMallLoginUrl, request, UserResponse.class);
    }
}
