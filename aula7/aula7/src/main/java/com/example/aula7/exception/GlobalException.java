package com.example.aula7.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    //Validar exceções do servuice
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> illegalArgumentException(IllegalArgumentException erro){
        return ResponseEntity.status(HttpStatus.CONFLICT)  
        .body(Map.of("mansagem", erro.getMessage()));
    }
    public ResponseEntity<Map<String, Object>> methodArgumentNotValidException(MethodArgumentNotValidException erro){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)  
        .body(Map.of("mansagem", erro.getFieldErrors().get(0).getDefaultMessage()));
    }
}
