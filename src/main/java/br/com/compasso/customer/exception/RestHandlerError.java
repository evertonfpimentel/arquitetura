package br.com.compasso.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.compasso.customer.util.ErrorMessage;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class RestHandlerError extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		log.error("customer internal server error: {}", ex.getMessage(), ex);

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				ErrorMessage.INTERNAL_SERVER_ERROR.getDescription());

		request.getDescription(false);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Object> handleAllExceptionsNotFound(Exception ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(),
				ErrorMessage.DATABASE_NOT_FOUND.getDescription());

		request.getDescription(false);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}
}
