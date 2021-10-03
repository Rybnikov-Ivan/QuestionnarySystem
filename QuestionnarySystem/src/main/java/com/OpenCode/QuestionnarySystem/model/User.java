package com.OpenCode.QuestionnarySystem.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(name = "first_name")
    private String name;

    @NotNull
    @Column(name = "login")
    private String userLogin;

    @NotNull
    @Column(name = "password")
    private String userPassword;

    @NotNull
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
}
