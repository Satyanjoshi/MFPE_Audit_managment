package com.mfpe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * Class to test AuditType Model
 */

@SpringBootTest
public class AuditTypeTests {

	//Testing noArgsConstructor, getter and setter methods
	@Test
	public void testGetterAndSetter() {
		AuditType auditType = new AuditType();
		auditType.setAuditType("new auditType");
		assertEquals("new auditType",auditType.getAuditType());
	}
	
	//testing allArgsConstructor and to string method
	@Test
	public void testConstructorAndToString() {
		AuditType auditType = new AuditType("diff auditType");
		assertEquals("AuditType(auditType=diff auditType)",auditType.toString());
	}
}
