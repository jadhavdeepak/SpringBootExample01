package com.deep.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDTO {

    private Long userId;
    private String userName;
    private String userEmail;
    private String phone;
    private String roleName;
    private String city;
}
