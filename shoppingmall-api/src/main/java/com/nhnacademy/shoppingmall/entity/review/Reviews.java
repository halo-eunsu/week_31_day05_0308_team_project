package com.nhnacademy.shoppingmall.entity.review;

import com.nhnacademy.shoppingmall.entity.product.Products;
import com.nhnacademy.shoppingmall.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Reviews")
@Getter
@Setter
public class Reviews {

    @Id
    @Column(name = "ReviewId")
    private int reviewId;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Products products;

    @Column(name = "Rating")
    private int rating;

    @Column(name = "Comments")
    private String comments;

}
