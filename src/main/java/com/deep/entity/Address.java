package com.deep.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;
    @NonNull
    private String street;
    @NonNull
    private String city;
    @NonNull
    private long pinCode;

    @ManyToOne
    @JsonIgnore
    private User user;
}
