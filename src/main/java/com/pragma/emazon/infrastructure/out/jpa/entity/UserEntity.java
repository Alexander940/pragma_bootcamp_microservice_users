package com.pragma.emazon.infrastructure.out.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "User")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "documentID", nullable = false)
    private String documentID;

    @Size(max = 13)
    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "birthday", nullable = false)
    private Calendar birthday;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "locked")
    private Integer locked;

    @Column(name = "disabled")
    private Integer disabled;

    @ManyToOne
    @JoinColumn(name = "roleuniqueid", nullable = false)
    private RoleEntity role;
}
