package com.mfpe.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/*
 * Class to test Exception Handler Advice class
 */
@SpringBootTest
public class ExceptionTests {

	@Autowired
	ExceptionHandlerAdvice exceptionHandlerAdvice;
	
	@Test
	public void contextLoads() throws Exception {
		assertNotNull(exceptionHandlerAdvice);
	}
	
	@Test
	public void testException() {
		List<String> dummyList = new ArrayList<>();
		Exception e = new Exception();
		assertEquals(new ResponseEntity<>(dummyList, HttpStatus.OK),exceptionHandlerAdvice.exception(e));
	}
}
