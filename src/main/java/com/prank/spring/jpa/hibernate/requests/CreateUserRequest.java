package com.prank.spring.jpa.hibernate.requests;

import com.prank.spring.jpa.hibernate.models.UserInfo;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder //lombok, create new instance with least effort
public class CreateUserRequest {
    @NotBlank
    String name;
    @NotBlank
    String address;
    @Email
    String email;
    @NotNull
    Integer phoneNum;

    /*
    * mapstruct dependency also used for mapping instead of builder
    * */
    public UserInfo toUser(){
        return UserInfo.builder()
                .name(this.name)
                .address(this.address)
                .email(this.email)
                .phone(this.phoneNum)
                .build();
    }

}
