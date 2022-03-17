package com.mfpe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@Entity
@Table(name = "question")
public class Question {
	
	@Id
	@GeneratedValue
	@Column(name="question_id")
	private int questionId;
	
	@NotEmpty(message = "Questions is required")
	@Column(name="question")
	private String question;
	
	@NotEmpty(message = "Audit Type is required")
	@Column(name="audit_type")
	private String auditType;
	
	@NotEmpty(message = "Response is required")
	@Column(name="response")
	private String response;
	
}
