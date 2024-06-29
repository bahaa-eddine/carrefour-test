package com.carrefour.delivery.controllers;

import com.carrefour.delivery.exceptions.TimeSlotNotBookedException;
import com.carrefour.delivery.exceptions.TimeSlotNotFoundException;
import com.carrefour.delivery.exceptions.TimeSlotAlreadyBookedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TimeSlotNotFoundException.class)
    public ResponseEntity<String> handleTimeSlotNotFoundException(TimeSlotNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TimeSlotAlreadyBookedException.class)
    public ResponseEntity<String> handleTimeSlotAlreadyBookedException(TimeSlotAlreadyBookedException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(TimeSlotNotBookedException.class)
    public ResponseEntity<String> handleTimeSlotNotBookedException(TimeSlotNotBookedException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

}
