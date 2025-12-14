package dev.droca.desafio_criptografia.entity;

import dev.droca.desafio_criptografia.entity.converter.CreditCardTokenConverter;
import dev.droca.desafio_criptografia.entity.converter.UserDocumentConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_table")
public class UserEntity {

    public UserEntity() {}
    
    public UserEntity(String userDocument, String creditCardToken, Long value) {
        this.userDocument = userDocument;
        this.creditCardToken = creditCardToken;
        this.value = value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_document" ,unique = true, nullable = true)
    @Convert(converter = UserDocumentConverter.class)
    private String userDocument;
    
    @Column(name = "credit_card_token", unique = true, nullable = true)
    @Convert(converter = CreditCardTokenConverter.class)
    private String creditCardToken;

    private Long value;

    public Long getId() {
        return id;
    }

    public String getUserDocument() {
        return userDocument;
    }

    public String getCreditCardToken() {
        return creditCardToken;
    }

    public Long getValue() {
        return value;
    }
    
}
