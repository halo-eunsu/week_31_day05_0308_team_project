package com.nhnacademy.accountapi.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    public static User createAdmin(String userId, String userName, String userPassword){
        return new User(userId,userName,userPassword);
    }

    public static User createUser(String userId, String userName, String userPassword){
        return new User(userId,userName,userPassword);
    }




}
