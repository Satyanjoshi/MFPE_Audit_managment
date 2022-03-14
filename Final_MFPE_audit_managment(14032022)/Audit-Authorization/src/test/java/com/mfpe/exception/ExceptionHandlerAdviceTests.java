package com.mfpe.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.mfpe.model.AuthenticationRequest;
import com.mfpe.model.AuthenticationResponse;

@SpringBootTest
public class ExceptionHandlerAdviceTests {
	
	@Autowired
	ExceptionHandlerAdvice exceptionHandlerAdvice;
	
	@Test
	public void contextLoads() throws Exception {
		assertNotNull(exceptionHandlerAdvice);
	}
	
	@Test
	public void testException() {
		Exception e = new Exception();
		AuthenticationResponse authenticationResponse = new AuthenticationResponse("Invalid", "Invalid", false);
		assertEquals( new ResponseEntity<>(authenticationResponse, HttpStatus.OK),exceptionHandlerAdvice.exception(e));
	}
	
	@Test
	public void testValidationException() {
		AuthenticationRequest request = new AuthenticationRequest();
		request.setUsername("");
		request.setPassword("");
		 BindingResult result = new BeanPropertyBindingResult(request, "username");
		MethodArgumentNotValidException e = new MethodArgumentNotValidException(null, result);
		assertEquals(new ResponseEntity<String>("Give Username and Password in proper-format", HttpStatus.FORBIDDEN),exceptionHandlerAdvice.validationExceptions(e));
	}
	
	
}
