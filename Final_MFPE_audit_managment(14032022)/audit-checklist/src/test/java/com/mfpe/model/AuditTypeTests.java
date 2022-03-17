package com.mfpe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * Class to test AuditType Model
 */

@SpringBootTest
public class AuditTypeTests {

	@Test
	public void testGetterAndSetter() {
		AuditType auditType = new AuditType();
		auditType.setAuditType("new auditType");
		assertEquals("new auditType",auditType.getAuditType());
	}
	
	@Test
	public void testConstructorAndToString() {
		AuditType auditType = new AuditType("diff auditType");
		assertEquals("AuditType(auditType=diff auditType)",auditType.toString());
	}
}
