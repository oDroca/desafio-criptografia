package dev.droca.desafio_criptografia.service;

import org.springframework.stereotype.Service;

import dev.droca.desafio_criptografia.dto.UserGetResponseDTO;
import dev.droca.desafio_criptografia.dto.UserRequestDTO;
import dev.droca.desafio_criptografia.dto.UserResponseDTO;
import dev.droca.desafio_criptografia.entity.UserEntity;
import dev.droca.desafio_criptografia.repository.UserRepository;

@Service
public class UserService {
    
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public UserResponseDTO createUser(UserRequestDTO userRequest) {

        UserEntity userEntity = new UserEntity(userRequest.userDocument(), userRequest.creditCardToken(), userRequest.value());
        UserEntity userSaved = userRepository.save(userEntity);
        
        return new UserResponseDTO(userSaved.getId(), userSaved.getUserDocument(), userSaved.getCreditCardToken(), userSaved.getValue());
    }
    
    public UserGetResponseDTO getUser(Long userId) {
        UserEntity userDatabase = userRepository.findById(userId).orElseThrow(() -> new RuntimeException());
        return new UserGetResponseDTO(userDatabase.getId(), userDatabase.getUserDocument(), userDatabase.getCreditCardToken(), userDatabase.getValue());
    }
}
