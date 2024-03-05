package com.nhnacademy.shoppingmall.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    private String id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_birth")
    private String birth;

    @Column(name = "user_auth")
    private String auth;

    @Column(name = "user_point")
    private int point;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "latest_login_at")
    private Date lastLogin;

//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
//    private List<Address> addresses;

//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
//    private List<Reviews> reviews;
}
