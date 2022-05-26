package it.crypto.dashboard.exception;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import it.crypto.dashboard.entity.dto.ErrorResponseClientDto;
import it.crypto.dashboard.entity.dto.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
        log.error("Exception Handler - Exception - ERRORE {} ", ex);
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponseClientDto error = new ErrorResponseClientDto("Errore inatteso", details);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnrecognizedPropertyException.class)
    public final ResponseEntity<Object> unrecognizedPropertyException(UnrecognizedPropertyException ex) {
        log.error("Exception Handler - UnrecognizedPropertyException - ERRORE {} ", ex);
        ErrorResponseDto error = new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(), "parametri di input non validi");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
