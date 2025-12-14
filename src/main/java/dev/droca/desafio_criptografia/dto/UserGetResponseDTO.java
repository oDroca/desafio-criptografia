package dev.droca.desafio_criptografia.dto;

public record UserGetResponseDTO(
    Long id,
    String userDocument,
    String creditCardToken,
    Long value
) {}