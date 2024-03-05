package com.nhnacademy.shoppingmall.entity;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {

    @Id
    @Column(name = "AddressID")
    private int addressId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "Address1")
    private String address1;

    @Column(name = "Address2")
    private String address2;


}
