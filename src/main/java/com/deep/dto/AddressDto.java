package com.deep.dto;

import com.deep.entity.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long addressId;
    private String street;
    private String city;
    private long pinCode;
    private User user;

}
