package com.mfpe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * Class to test Question Model
 */

@SpringBootTest
public class QuestionTests {

	//Testing noArgsConstructor, getter and setter methods
	@Test
	public void testGetterAndSetter() {
		Question question = new Question();
		question.setQuestionId(11);
		question.setQuestion("new Question");
		question.setAuditType("new auditType");
		question.setResponse("yes");
		assertEquals(11,question.getQuestionId());
		assertEquals("new auditType",question.getAuditType());
		assertEquals("new Question",question.getQuestion());
		assertEquals("yes",question.getResponse());
	}
	
	//testing allArgsConstructor and to string method
	@Test
	public void testConstructorAndToString() {
//		Question question = new Question(11,"new Question","new auditType","yes");
//		assertEquals("Question(questionId=11,question=new Question,auditType=new auditType,response=yes)",question.toString());
//		
		Question question = new Question(11,"new Question","new auditType","yes");
		assertEquals("Question(questionId=11, question=new Question, auditType=new auditType, response=yes)",question.toString());
	}
}
