package com.mfpe.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectManagerTest {

	@Test
	public void testGetterAndSetter() {
		ProjectManager obj = new ProjectManager();
		
		obj.setId(1);
		obj.setName("abhi");
		obj.setUsername("abhi123");
		obj.setPassword("abhi1234");
		obj.setProjectName("project1");
		
		assertEquals(1,obj.getId());
		assertEquals("abhi",obj.getName());
		assertEquals("abhi123",obj.getUsername());
		assertEquals("abhi1234",obj.getPassword());
		assertEquals("project1",obj.getProjectName());
	}
	
	@Test
	public void testConstructorAndToString() {
		ProjectManager obj = new ProjectManager(1,"abhishek","abhis","abhii123","project1");
		assertEquals("ProjectManager(id=1, name=abhishek, username=abhis, password=abhii123, projectName=project1)",obj.toString());
	}
}
