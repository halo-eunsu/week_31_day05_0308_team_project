package com.nhnacademy.accountapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Table(name = "Users")
@Entity
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    private final String userId;

    @Column(name = "user_name")
    private final String userName;

    @Column(name = "user_password")
    private final String userPassword;



//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "user_auth")
//    private final String userAuth;
    private final List<String> userRoles;

    public static enum ROLE{
        ROLE_ADMIN("관리자"),
        ROLE_USER("회원");

        ROLE(String role) {
        }
    }
    public static User createAdmin(String userId, String userName, String userPassword){
        return new User(userId,userName,userPassword,List.of(ROLE.ROLE_ADMIN.name()));
    }

    public static User createUser(String userId, String userName, String userPassword){
        return new User(userId,userName,userPassword,List.of(ROLE.ROLE_USER.name()));
    }

//    private User(String userId, String userName, String userPassword, List<String> userRoles) {
//        this.userId = userId;
//        this.userName = userName;
//        this.userPassword = userPassword;
//        this.userRoles = userRoles;
//    }
}