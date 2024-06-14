package com.api.clientes.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataAccessException(DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data access error: " + e.getMessage());
    } 

	@ExceptionHandler(CustomerCreateException.class)
	public ResponseEntity<String> handleCustomerCreateException(CustomerCreateException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer not created: " + e.getMessage());
	}
}
