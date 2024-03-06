package com.nhnacademy.shoppingmall.entity.review;

import com.nhnacademy.shoppingmall.entity.product.Products;
import com.nhnacademy.shoppingmall.entity.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository repository;

    @Override
    public List<Reviews> getReviewByProductId(Products products) {
        return repository.findAllByProducts(products);
    }

    @Override
    public List<Reviews> getReviewByUserId(User user) {
        return repository.findAllByUser(user);
    }

    @Override
    public void deleteReview(int reviewId) {
        repository.deleteById(reviewId);
    }

    @Override
    public void modifyReview(Reviews reviews) {
        Reviews targetReview = repository.findById(reviews.getReviewId()).get();
        targetReview.setComments(reviews.getComments());
        targetReview.setRating(reviews.getRating());
        repository.saveAndFlush(targetReview);
    }

    @Override
    public void createReview(Reviews reviews) {
        repository.save(reviews);
    }
}
