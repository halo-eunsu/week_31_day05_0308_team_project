package com.nhnacademy.accountapi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Getter
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    private final String userId;

    @Column(name = "user_name")
    private final String userName;

    @Column(name = "user_password")
    private final String userPassword;

    @Column(name = "user_auth")
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
    
    private User(String userId, String userName, String userPassword, List<String> userRoles) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRoles = userRoles;
    }
}