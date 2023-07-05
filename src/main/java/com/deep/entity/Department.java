package com.deep.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deptId;
    @NonNull
    private String deptName;
    private String deptDesc;

    @OneToOne
    @JoinColumn(name = "ud_fk", nullable = false)
    private User user;

}
