package dev.droca.desafio_criptografia.dto;

public record UserRequestDTO(
    Long id,
    String userDocument,
    String creditCardToken,
    Long value
) {}
