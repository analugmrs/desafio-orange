package com.analugmrs.desafio.repository.repositories;

import com.analugmrs.desafio.repository.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    boolean existsByEmail(String Email);
}
