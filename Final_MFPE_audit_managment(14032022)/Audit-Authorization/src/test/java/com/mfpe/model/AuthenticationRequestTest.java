package com.mfpe.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthenticationRequestTest {
	@Test
	public void testAuthRequest()
	{
		AuthenticationRequest obj = new AuthenticationRequest();
		obj.setUsername("hriday");
		obj.setPassword("hri1234");
		assertNotNull(obj.getUsername());
		assertNotNull(obj.getPassword());
		assertEquals("hriday",obj.getUsername());
		assertEquals("hri1234",obj.getPassword());
		assertEquals("AuthenticationRequest(username=hriday, password=hri1234)",obj.toString());
	}
}
