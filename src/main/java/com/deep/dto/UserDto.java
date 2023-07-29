package com.deep.dto;

import com.deep.entity.Address;
import com.deep.entity.UserRole;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long userId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String userEmail;
    private String phone;
    private String userRole;
    private Set<UserRole> userRoles;
    private Set<Address> addresses;
}
