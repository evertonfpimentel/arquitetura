package br.com.compasso.customer.exception;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class ExceptionResponse {

	private Integer code;
	private String message;

	public ExceptionResponse(Integer code, String details) {
		this.code = code;
		this.message = details;
	}
}
