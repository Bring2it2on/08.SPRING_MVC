package com.ohgiraffers.example.member.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SignupDTO {

    private String memberId;
    private String password;
    private String name;
    private String role;
}
