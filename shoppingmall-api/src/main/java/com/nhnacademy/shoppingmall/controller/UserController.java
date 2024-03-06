package com.nhnacademy.shoppingmall.controller;

import com.nhnacademy.shoppingmall.entity.user.User;
import com.nhnacademy.shoppingmall.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserRepository userRepository;

    @PostMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable String userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            HashMap<String, String> resp = new HashMap<>();
            resp.put("id", user.getId());
            resp.put("name", user.getName());
            resp.put("birth",user.getBirth());
            resp.put("auth", user.getAuth());
            resp.put("point", String.valueOf(user.getPoint()));
            resp.put("createAt", String.valueOf(user.getCreatedAt()));
            resp.put("lastLogin", String.valueOf(user.getLastLogin()));
            return ResponseEntity.ok(resp);
        }
        HashMap<String, String> errorResp = new HashMap<>();
        errorResp.put("error", "Invalid User");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResp);
    }
}
