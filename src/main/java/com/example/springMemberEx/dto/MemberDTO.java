package com.example.springMemberEx.dto;

import lombok.Data;

@Data
public class MemberDTO {
    private long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

}
