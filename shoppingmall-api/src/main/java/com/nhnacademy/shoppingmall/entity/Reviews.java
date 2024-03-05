package com.nhnacademy.shoppingmall.entity;

import javax.persistence.*;

@Entity
@Table(name = "Reviews")
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
