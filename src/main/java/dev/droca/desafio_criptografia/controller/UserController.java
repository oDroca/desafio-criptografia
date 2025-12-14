package dev.droca.desafio_criptografia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.droca.desafio_criptografia.dto.UserGetResponseDTO;
import dev.droca.desafio_criptografia.dto.UserRequestDTO;
import dev.droca.desafio_criptografia.dto.UserResponseDTO;
import dev.droca.desafio_criptografia.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/criptografia")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/user")
    public ResponseEntity<UserResponseDTO> postMethodName(@RequestBody UserRequestDTO userRequest) {
        UserResponseDTO response = userService.createUser(userRequest);
        return new ResponseEntity<UserResponseDTO>(response, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserGetResponseDTO> getUser(@PathVariable Long userId) {
        UserGetResponseDTO response = userService.getUser(userId);
        return new ResponseEntity<UserGetResponseDTO>(response, HttpStatus.OK);
    }
    
    
}
