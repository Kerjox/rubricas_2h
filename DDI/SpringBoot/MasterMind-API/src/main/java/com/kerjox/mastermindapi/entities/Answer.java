package com.kerjox.mastermindapi.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Answer {

	private String answer[];
	private String message;
	private String reason;
}
