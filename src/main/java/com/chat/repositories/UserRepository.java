package com.chat.repositories;

import java.util.UUID;

import com.chat.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    public User findUserByEmail(@Param("email") String email);
}
