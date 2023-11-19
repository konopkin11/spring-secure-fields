package com.invisibles.springsecurefields.examples.repositoryies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invisibles.springsecurefields.examples.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
