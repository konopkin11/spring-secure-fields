package com.invisibles.springsecurefields.examples.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "authorities")
@Entity
public class Authorities {

    @Id
    String authority;
    String username;
}
