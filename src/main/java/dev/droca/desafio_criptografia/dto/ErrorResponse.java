package dev.droca.desafio_criptografia.dto;

public record ErrorResponse(
    String message,
    String date,
    String titleError,
    Integer codeError
) {}
