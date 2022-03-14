package com.mfpe.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectManagerDetailsTest {


	@Test
	public void testGetPassword() {
		ProjectManagerDetails obj = new ProjectManagerDetails();
		assertEquals(null,obj.getPassword());
	}

	@Test
	public void testGetUsername() {
		ProjectManagerDetails obj = new ProjectManagerDetails();
		assertEquals(null,obj.getUsername());
	}

	@Test
	public void testIsAccountNonExpired() {
		ProjectManagerDetails obj = new ProjectManagerDetails();
		assertEquals(true,obj.isAccountNonExpired());
	}

	@Test
	public void testIsCredentialsNonExpired() {
		ProjectManagerDetails obj = new ProjectManagerDetails();
		assertEquals(true,obj.isCredentialsNonExpired());
	}

	@Test
	public void testIsEnabled() {
		ProjectManagerDetails obj = new ProjectManagerDetails();
		assertEquals(true,obj.isEnabled());
	}

	@Test
	public void testIsAccountNonLocked() {
		ProjectManagerDetails obj = new ProjectManagerDetails();
		assertEquals(true,obj.isAccountNonLocked());
	}
	
	@Test
	public void testGetAuthorities() {
		ProjectManagerDetails obj = new ProjectManagerDetails();
		assertEquals(new ArrayList<>(),obj.getAuthorities());
	}
	

}
