package dev.droca.desafio_criptografia.dto;

public record UserResponseDTO(
    Long id,
    String userDocument,
    String creditCardToken,
    Long value
) {}