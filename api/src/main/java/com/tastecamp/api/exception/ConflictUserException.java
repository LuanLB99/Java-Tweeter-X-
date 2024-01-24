package com.tastecamp.api.exception;

public class ConflictUserException extends Exception {
    
    public ConflictUserException() {
        super("Nome de de usuário em uso!");
    }
}
