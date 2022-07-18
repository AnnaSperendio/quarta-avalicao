package com.br.compass.avaliacao4.handler;

import com.br.compass.avaliacao4.entities.PartidoEntity;
import com.br.compass.avaliacao4.exceptions.IdeologiaInvalidException;
import com.br.compass.avaliacao4.exceptions.PartidoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler {

    private static final String PARTIDO_NOT_FOUND = "Partido não Encontrado.";
    private static final String IDEOLOGIA_INVÁLIDA = "Ideologia não válida";

    @ExceptionHandler(value = {PartidoNotFoundException.class})
    protected ResponseEntity<ErrorMessage> handlerStateNotFound(PartidoNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage(PARTIDO_NOT_FOUND));
    }

    @ExceptionHandler(value = {IdeologiaInvalidException.class})
    protected ResponseEntity<ErrorMessage> handlerIdeologiaInvalid(IdeologiaInvalidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(IDEOLOGIA_INVÁLIDA));
    }


}
