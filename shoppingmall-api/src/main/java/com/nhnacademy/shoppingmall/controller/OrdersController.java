package com.nhnacademy.shoppingmall.controller;

import com.nhnacademy.shoppingmall.entity.order.OrderService;
import com.nhnacademy.shoppingmall.entity.order.Orders;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrdersController {

    private final OrderService orderService;

    @PostMapping("/{orderId}")
    public ResponseEntity<?> getOrder(@PathVariable int orderId) {
        Optional<Orders> optionalOrders = orderService.getOrders(orderId);
        if (optionalOrders.isPresent()) {
            HashMap<String, String> resp = getStringStringHashMap(optionalOrders);
            return ResponseEntity.ok(resp);
        }
        HashMap<String, String> errorResp = new HashMap<>();
        errorResp.put("error", "Invalid orderId");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResp);

    }

    private static HashMap<String, String> getStringStringHashMap(Optional<Orders> optionalOrders) {
        Orders orders = optionalOrders.get();

        HashMap<String, String> resp = new HashMap<>();
        resp.put("orderDate", String.valueOf(orders.getOrderDate()));
        resp.put("shipDate", String.valueOf(orders.getShipDate()));
        resp.put("orderId", String.valueOf(orders.getOrderId()));
        resp.put("userId", orders.getUser().getId());
        resp.put("userName", orders.getUser().getName());
        resp.put("userPoint", String.valueOf(orders.getUser().getPoint()));
        return resp;
    }
}
