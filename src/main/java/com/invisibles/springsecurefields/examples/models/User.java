package com.invisibles.springsecurefields.examples.models;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.invisibles.springsecurefields.core.Allowed;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@JsonFilter("AllowedFilter")
public class User {


 /*   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Allowed(authorities = {"CAN_READ_ADMIN", "CAN_READ_USER"})
    private Long id;*/
    @Allowed(authorities = {"CAN_READ_ADMIN", "CAN_READ_USER"})
    private String email = "test@mail.ru";
    @Allowed(authorities = {"CAN_READ_ADMIN"})
    private String password;
    @Allowed(authorities = {"CAN_READ_USER"})
    private String onlyUserData = "onlyuserdata";
    @Allowed(authorities = {"CAN_READ_ADMIN"})
    private String onlyAdminData = "onlyadmindata";
    @Id
    private String username;
    @Column
    private Boolean enabled;
    @Column
    private Integer priority;
}
