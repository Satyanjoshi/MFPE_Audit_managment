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
		obj.setName("harry");
		obj.setUsername("harry123");
		obj.setPassword("hari1234");
		obj.setProjectName("project1");
		
		assertEquals(1,obj.getId());
		assertEquals("harry",obj.getName());
		assertEquals("harry123",obj.getUsername());
		assertEquals("hari1234",obj.getPassword());
		assertEquals("project1",obj.getProjectName());
	}
	
	@Test
	public void testConstructorAndToString() {
		ProjectManager obj = new ProjectManager(1,"hriday","hrid7","hrid123","project1");
		assertEquals("ProjectManager(id=1, name=hriday, username=hrid7, password=hrid123, projectName=project1)",obj.toString());
	}
}
