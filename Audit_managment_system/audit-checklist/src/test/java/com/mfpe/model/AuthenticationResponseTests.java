package com.mfpe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * Class to test AuthenticationResponse Model
 */

@SpringBootTest
public class AuthenticationResponseTests {

	//Testing noArgsConstructor, getter and setter methods
	@Test
	public void testGetterAndSetter() {
		AuthenticationResponse authResponse = new AuthenticationResponse();
		authResponse.setName("Rahul");
		authResponse.setProjectName("Project-1");
		authResponse.setValid(false);
		assertEquals("Rahul",authResponse.getName());
		assertEquals("Project-1",authResponse.getProjectName());
		assertEquals(false,authResponse.isValid());
	}
	
	//testing allArgsConstructor and to string method
	@Test
	public void testConstructorAndToString() {
		AuthenticationResponse authResponse = new AuthenticationResponse("Rahul","Project-1",false);
		assertEquals("AuthenticationResponse(name=Rahul, projectName=Project-1, isValid=false)",authResponse.toString());
	}
}
