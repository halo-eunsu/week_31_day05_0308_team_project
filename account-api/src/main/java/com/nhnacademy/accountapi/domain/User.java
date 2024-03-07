package com.nhnacademy.accountapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "User")
public class User {

    @Id
    @Column(name = "user_id")
    private String userId;

    private final String userName;
    private final String userPassword;

    public User() {}

    public static enum ROLE{
        ROLE_ADMIN("관리자"),
        ROLE_USER("회원");

        ROLE(String role) {
        }
    }

    private User(String userId, String userName, String userPassword, List<String> userRoles) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRoles = userRoles;
    }
}