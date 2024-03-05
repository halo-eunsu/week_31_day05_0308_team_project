package com.nhnacademy.gateway.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@AllArgsConstructor()
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class BlackList {
    @Id
    private String userId;
}
