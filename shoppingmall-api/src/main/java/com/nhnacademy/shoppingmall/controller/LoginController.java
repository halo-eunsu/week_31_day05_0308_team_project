package com.nhnacademy.shoppingmall.controller;

import com.nhnacademy.shoppingmall.entity.user.User;
import com.nhnacademy.shoppingmall.entity.user.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> doLogin(@RequestBody LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.findById(loginRequest.getId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (user.getPassword() != null && user.getPassword().equals(loginRequest.getPassword())) {
                HashMap<String, String> resp = new HashMap<>();
                resp.put("id", loginRequest.getId());
                resp.put("name", user.getName());
                return ResponseEntity.ok(resp);
            }

        }
        HashMap<String, String> errorResp = new HashMap<>();
        errorResp.put("error", "Invalid ID or PASSWORD");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResp);
    }

    @Getter
    static class LoginRequest {
        private String id;
        private String password;

        public LoginRequest(String validId, String validPassword) {
        }
    }

    @Getter
    static class LoginResponse {
        private String id;
        private String email;
        private String password;
    }
}
