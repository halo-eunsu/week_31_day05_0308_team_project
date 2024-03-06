package com.nhnacademy.shoppingmall.entity.review;

import com.nhnacademy.shoppingmall.entity.product.Products;
import com.nhnacademy.shoppingmall.entity.user.User;

import java.util.List;

public interface ReviewService {

    List<Reviews> getReviewByProductId(Products products);
    List<Reviews> getReviewByUserId(User user);
    void deleteReview(int reviewId);
    void modifyReview(Reviews reviews);
    void createReview(Reviews reviews);


}
