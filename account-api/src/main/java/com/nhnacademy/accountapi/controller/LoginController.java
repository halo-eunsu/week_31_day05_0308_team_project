//package com.nhnacademy.accountapi.controller;
//
//import com.nhnacademy.accountapi.domain.User;
//import com.nhnacademy.accountapi.domain.UserRepository;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Optional;
//
//@RestController
//@RequiredArgsConstructor
//public class LoginController {
//
//    private final UserRepository userRepository;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> doLogin(@RequestBody LoginRequest loginRequest){
//        Optional<User> userOptional= userRepository.findById(loginRequest.getId());
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//
//            if (user.getUserPassword() != null && user.getUserPassword().equals(loginRequest.getPassword())) {
//                HashMap<String, String> resp = new HashMap<>();
//                resp.put("id", loginRequest.getId());
//                resp.put("name", user.getUserName());
//
//                return ResponseEntity.ok(resp);
//            }
//        }
//        HashMap<String, String> errorResp = new HashMap<>();
//        errorResp.put("error", "Invalid ID or PASSWORD");
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResp);
//    }
//
//    @Getter
//    static class LoginRequest {
//        private String id;
//        private String password;
//
//        public LoginRequest(String validId, String validPassword) {
//        }
//    }
//}
