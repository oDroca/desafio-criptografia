package dev.droca.desafio_criptografia.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDateTime;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.droca.desafio_criptografia.dto.ErrorResponse;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleGenericError(Exception e) {
        return new ErrorResponse(e.getMessage(), LocalDateTime.now().toString(), "Internal Server Error", 500);
    }

    @ExceptionHandler(NoSuchAlgorithmException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleNoSuchAlgorithmException(NoSuchAlgorithmException e) {
        return new ErrorResponse(e.getMessage(), LocalDateTime.now().toString(), "Bad Request", 500);        
    }

    @ExceptionHandler(NoSuchPaddingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleNoSuchPaddingException(NoSuchPaddingException e) {
        return new ErrorResponse(e.getMessage(), LocalDateTime.now().toString(), "Bad Request", 500);        
    }

    @ExceptionHandler(InvalidKeyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidKeyException(InvalidKeyException e) {
        return new ErrorResponse(e.getMessage(), LocalDateTime.now().toString(), "Bad Request", 500);        
    }

    @ExceptionHandler(IllegalBlockSizeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleIllegalBlockSizeException(IllegalBlockSizeException e) {
        return new ErrorResponse(e.getMessage(), LocalDateTime.now().toString(), "Bad Request", 500);        
    }

    @ExceptionHandler(BadPaddingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadPaddingException(BadPaddingException e) {
        return new ErrorResponse(e.getMessage(), LocalDateTime.now().toString(), "Bad Request", 500);        
    }

    @ExceptionHandler(InvalidKeySpecException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidKeySpecException(InvalidKeySpecException e) {
        return new ErrorResponse(e.getMessage(), LocalDateTime.now().toString(), "Bad Request", 500);        
    }
    
}
