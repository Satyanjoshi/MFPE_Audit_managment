package com.mfpe.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import org.slf4j.Logger;

import com.mfpe.model.AuditType;
import com.mfpe.model.Question;
import com.mfpe.service.AuthorizationService;
import com.mfpe.service.QuestionService;

/*
 * Class to test AuditCheckListController 
 */

@SpringBootTest
public class AuditChecklistControllerTests {
	
	@Mock
	QuestionService questionService;
	
	@Mock
	AuthorizationService authorizationService;
	
	@Mock
	Logger logger;
	
	@InjectMocks
	AuditChecklistController controller;
	
	@Test
	public void contextLoads() {
		assertNotNull(controller);
	}
	
	//testing health check method
	
	
	//testing auditCheckListQuestions method
	@Test
	public void testAuditChecklistQuestions() {
		List<Question> questions =  new ArrayList<Question>();
		questions.add(new Question(1,"question","auditType","response"));
		
		when(logger.isInfoEnabled()).thenReturn(true);
		
		when(logger.isErrorEnabled()).thenReturn(true);
		
		when(authorizationService.validateJwt("jwt")).thenReturn(true);
		
		AuditType auditType = new AuditType("auditType");
		
		when(questionService.getQuestionsByAuditType(auditType)).thenReturn(questions);
		
		assertEquals(questions, controller.auditCheckListQuestions("jwt", auditType));		
		
		
	}
	@Test
	public void testHealthCheck() {
		assertEquals("Audit Checklist Microservice is Active", controller.healthCheck());
	}
	
}
