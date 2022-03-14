package com.mfpe.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ProjectManagerNotFoundExceptionTests {


	@Test
	public void testException() {
		assertEquals("Project Manager is Not Found",(new ProjectManagerNotFoundException("Project Manager is Not Found")).getMessage());
	}
}
