package tn.com.smarteck.project.controllers;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExpHandle {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegale(IllegalArgumentException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(e.getMessage());
				
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuch(NoSuchElementException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(e.getMessage());
				
	}
}
