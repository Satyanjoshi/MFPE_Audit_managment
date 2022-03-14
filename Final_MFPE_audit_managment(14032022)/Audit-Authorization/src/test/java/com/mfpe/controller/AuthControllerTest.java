package com.mfpe.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.mfpe.model.AuthenticationRequest;
import com.mfpe.model.AuthenticationResponse;
import com.mfpe.model.ProjectManager;
import com.mfpe.model.ProjectManagerDetails;
import com.mfpe.service.JwtService;
import com.mfpe.service.ProjectManagerDetailsService;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {
	
	@Mock
	private AuthenticationManager authenticationManager;
	
	@Mock
	private ProjectManagerDetailsService projectManagerDetailsService;
	
	@Mock
	private JwtService jwtService;
	
	@InjectMocks
	private AuthController authController;	// from where we will assert
	
	@Test	
	public void generateJwtTest(){
	
		ResponseEntity<String> response = null;
		AuthenticationRequest request = null;
		ProjectManagerDetails projectManagerDetails = null;
		ProjectManager projectManager = null;
		
		request = new AuthenticationRequest();
		request.setUsername("user1");
		request.setPassword("abcd1234");
	
		projectManager= new ProjectManager(1, "name1", "user1", "abcd1234", "Project1");
		
		projectManagerDetails = new ProjectManagerDetails(projectManager);
		
		final String jwtToken = "jj.ww.tt";
		// making response
		response = new ResponseEntity<String>(jwtToken, HttpStatus.OK);
		
		when(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())))
			.thenReturn(null);
		when(projectManagerDetailsService.loadUserByUsername(request.getUsername())).thenReturn(projectManagerDetails);
		when(jwtService.generateToken(projectManagerDetails)).thenReturn(jwtToken);
		assertEquals(response, authController.generateJwt(request));
		
		
		request = new AuthenticationRequest();
		request.setUsername("invalidUser1");
		request.setPassword("abcd1234");
		projectManager= null;
		
		projectManagerDetails = null;
	
		response = new ResponseEntity<String>("Not Authorized Project Manager", HttpStatus.FORBIDDEN);
		
	
		when(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())))
			.thenReturn(null);
		when(projectManagerDetailsService.loadUserByUsername(request.getUsername())).thenThrow(RuntimeException.class);
		assertEquals(response, authController.generateJwt(request));
	}

	@Test	
	public void validateJwt(){
		
		String jwtTokenHeader = "Bearer jj.ww.tt";
		AuthenticationResponse authenticationResponse = null;
		ResponseEntity<AuthenticationResponse> response = null;
		ProjectManagerDetails projectManagerDetails = null;
		ProjectManager projectManager = null;
		projectManager= new ProjectManager(1, "name1", "user1", "abcd1234", "Project1");
		projectManagerDetails = new ProjectManagerDetails(projectManager);
		authenticationResponse = new AuthenticationResponse("name1", "Project1", true);
		String jwtToken = jwtTokenHeader.substring(7);
		String username = "user1";
		response = new ResponseEntity<AuthenticationResponse>(authenticationResponse, HttpStatus.OK);
		
		when(jwtService.extractUsername(jwtToken)).thenReturn(username);
		when(projectManagerDetailsService.loadUserByUsername(username))
							.thenReturn(projectManagerDetails);
		when(jwtService.validateToken(jwtToken, projectManagerDetails)).thenReturn(true);	// correct
		assertEquals(response, authController.validateJwt(jwtTokenHeader));
	
		jwtTokenHeader = "Bearer jj.wrong.tt";
	
		projectManager= null;
		
		projectManagerDetails = null;
	
		authenticationResponse = new AuthenticationResponse("Invalid", "Invalid", false);
		username = "";
	
		jwtToken = jwtTokenHeader.substring(7);
		response = new ResponseEntity<AuthenticationResponse>(authenticationResponse, HttpStatus.OK);
		
		
		when(jwtService.extractUsername(jwtToken)).thenReturn(username);
		when(projectManagerDetailsService.loadUserByUsername(username)).thenReturn(projectManagerDetails);
		when(jwtService.validateToken(jwtToken, projectManagerDetails)).thenReturn(false);	// wrong
		assertEquals(response, authController.validateJwt(jwtTokenHeader));
	}
}
