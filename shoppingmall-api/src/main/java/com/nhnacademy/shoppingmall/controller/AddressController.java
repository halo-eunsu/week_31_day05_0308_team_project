package com.nhnacademy.shoppingmall.controller;

import com.nhnacademy.shoppingmall.entity.address.Address;
import com.nhnacademy.shoppingmall.entity.address.AddressRepository;
import com.nhnacademy.shoppingmall.entity.address.AddressService;
import com.nhnacademy.shoppingmall.entity.user.User;
import com.nhnacademy.shoppingmall.entity.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;
    private final UserService userService;

    @PostMapping("/{addressId}")
    public ResponseEntity<?> getAddress(@PathVariable int addressId) {

        Optional<Address> optionalAddress = addressService.getAddress(addressId);
        if (optionalAddress.isPresent()) {
            Address address = optionalAddress.get();
            HashMap<String, String> resp = new HashMap<>();
            resp.put("address", address.getAddress1());
            resp.put("addressDetail", address.getAddress2());
            return ResponseEntity.ok(resp);
        }
        HashMap<String, String> errorResp = new HashMap<>();
        errorResp.put("error", "Invalid AddressId");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResp);
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<?> getAddress(@PathVariable String userId) {
        //TODO: userId로 Address 찾기
        Optional<User> optionalUser = userService.getUser(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            List<Address> addresses = addressService.getAddresses(user);

            HashMap<String, List<Address>> resp = new HashMap<>();
            resp.put("address", addresses);
            return ResponseEntity.ok(resp);
        }
        HashMap<String, String> errorResp = new HashMap<>();
        errorResp.put("error", "Invalid userId");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResp);
    }
}
