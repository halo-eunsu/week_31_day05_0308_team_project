package com.nhnacademy.accountapi.controller;

import com.nhnacademy.accountapi.domain.User;
import com.nhnacademy.accountapi.domain.UserRepository;
import com.nhnacademy.accountapi.dto.UserResponse;
import com.nhnacademy.accountapi.security.details.CustomUserDetailsService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/account/users")
public class AccountController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<UserResponse> getUser(@RequestHeader("X-USER-ID") String userId){
        log.debug("X-USER-ID:{}",userId);
        //TODO#6 회원조회 API를 구현합니다.
        //UserResponse <-- 각 팀별로 설계한 회원 스키마를 고려하여 수정합니다.
        //X-USER-ID는 Gateway에서 access-token을 검증 후 valid한 token이면 jwt의 payload의 userId를 Header에  X-USER-ID로 추가 합니다.
        //회원은 shoppingmall-api 서버에 회원을 조회할 수 있는 api를 개발<-- 해당 API를 호출 합니다.
        User user = (User) customUserDetailsService.loadUserByUsername(userId);
        if (user==null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new UserResponse(user.getUserId(), user.getUserName()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> doLogin(@RequestBody LoginRequest loginRequest){
        Optional<User> userOptional= userRepository.findById(loginRequest.getId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (user.getUserPassword() != null && user.getUserPassword().equals(loginRequest.getPassword())) {
                HashMap<String, String> resp = new HashMap<>();
                resp.put("id", loginRequest.getId());
                resp.put("name", user.getUserName());

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
}
