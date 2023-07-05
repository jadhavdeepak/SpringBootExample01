package com.deep.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(unique = true, nullable = false, length = 50)
    private String username;
    @Column(nullable = false, length = 50)
    private String password;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    private String userEmail;
    private String phone;
    @Column(nullable = false)
    private String userRole;
    private boolean enabled = true;
    private String profile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Department department;

    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
    private List<Address> addresses;

}
