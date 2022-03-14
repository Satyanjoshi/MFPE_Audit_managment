package com.mfpe.filter;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mfpe.service.JwtService;
import com.mfpe.service.ProjectManagerDetailsService;

@SpringBootTest
class JwtRequestFilterTest {

	@Mock
	private ProjectManagerDetailsService projectManagerDetailsService;

	@Mock
	private JwtService jwtService;
	
	@Autowired
	JwtRequestFilter jwtRequestFilter;
	
	@Test
	public void testDoFilterInternal() {

	}

}
