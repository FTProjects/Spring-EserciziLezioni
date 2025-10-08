package com.example.demo_REST_exception.controller.advice;

import com.example.demo_REST_exception.exception.NotEnoughMoneyException;
import com.example.demo_REST_exception.model.dto.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// un punto centrale per la gestione delle eccezioni
// che vengono lanciate al controller
@RestControllerAdvice
public class ExceptionControllerAdvice {

    // creiamo un metodo che scatta quando viene
    // lanciata una NotEnougMoneyException al controller
    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> moneyHandler() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Non ci sono abbastanza fondi...");
        return ResponseEntity.badRequest().body(errorDetails);
    }
}
