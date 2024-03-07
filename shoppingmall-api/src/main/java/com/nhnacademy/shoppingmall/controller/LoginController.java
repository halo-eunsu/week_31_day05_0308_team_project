package com.nhnacademy.shoppingmall.controller;

import com.nhnacademy.shoppingmall.entity.user.User;
import com.nhnacademy.shoppingmall.entity.user.UserService;
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
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> doLogin(@RequestBody LoginRequest loginRequest) {
        Optional<User> optionalUser = userService.getUser(loginRequest.id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            HashMap<String, String> resp = new HashMap<>();
            resp.put("userId", user.getId());
            resp.put("userName", user.getName());

            return ResponseEntity.ok(resp);
        }
        HashMap<String, String> errorResp = new HashMap<>();
        errorResp.put("error", "Invalid ID or Password");
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
