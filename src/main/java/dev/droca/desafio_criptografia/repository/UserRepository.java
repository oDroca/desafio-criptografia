package dev.droca.desafio_criptografia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.droca.desafio_criptografia.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {}
 