package com.nhnacademy.shoppingmall.controller;

import com.nhnacademy.shoppingmall.entity.product.ProductRepository;
import com.nhnacademy.shoppingmall.entity.product.Products;
import com.nhnacademy.shoppingmall.entity.review.ReviewRepository;
import com.nhnacademy.shoppingmall.entity.review.Reviews;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/review")
@AllArgsConstructor
public class ReviewController {

    private final ReviewRepository repository;
    private final ProductRepository productRepository;


    @PostMapping("/{reviewId}")
    public ResponseEntity<?> getReview(@PathVariable int reviewId) {
        Optional<Reviews> reviewsOptional = repository.findById(reviewId);
        if (reviewsOptional.isPresent()) {
            Reviews review = reviewsOptional.get();
            HashMap<String, String> resp = new HashMap<>();
            resp.put("comments", review.getComments());
            resp.put("userId", review.getUser().getId());
            resp.put("userName", review.getUser().getName());
            return ResponseEntity.ok(resp);
        }
        HashMap<String, String> errorResp = new HashMap<>();
        errorResp.put("error", "Invalid reviewId");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResp);
    }

    //TODO: 특정 Product 에 관한 Review 를 찾기
    @PostMapping("/product/{productId}/")
    public ResponseEntity<?> getProductReviews(@PathVariable int productId) {
        Optional<Products> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Products product = optionalProduct.get();
            List<Reviews> reviews = repository.findAllByProducts(product);

            HashMap<String, List<Reviews>> resp = new HashMap<>();
            resp.put("reviews", reviews);
            return ResponseEntity.ok(resp);
        }
        HashMap<String, String> errorResp = new HashMap<>();
        errorResp.put("error", "Invalid ProductId");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResp);
    }
}