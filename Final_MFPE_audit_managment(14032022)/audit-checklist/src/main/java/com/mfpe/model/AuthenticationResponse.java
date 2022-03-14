package com.mfpe.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Component

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
	private String name;
	private String projectName;
	private boolean isValid;
}
