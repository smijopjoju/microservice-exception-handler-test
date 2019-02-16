package my.microservice.exception.handler.test.exception.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import my.microservice.exception.handler.test.exception.ExceptionInfo;
import my.microservice.exception.handler.test.exception.UserNotFoundException;
import my.microservice.exception.handler.test.exception.UserNotSavedException;
import my.microservice.exception.handler.test.exception.UserNotUpdatedException;
import my.microservice.exception.handler.test.exception.UserValidationException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(UserNotSavedException.class)
	protected ResponseEntity<?> handleUserNotSavedException( Exception ex, WebRequest req) {
		return new ResponseEntity<>(new ExceptionInfo(HttpStatus.INTERNAL_SERVER_ERROR,"User Not saved",ex),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	protected ResponseEntity<?> handleUserNotFoundException( Exception ex, WebRequest req) {		
		return new ResponseEntity<>(new ExceptionInfo(HttpStatus.NOT_FOUND,"User not found",ex),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserValidationException.class)
	protected ResponseEntity<?> handleUserValidationException( Exception ex, WebRequest req) {
		return new ResponseEntity<>(new ExceptionInfo(HttpStatus.BAD_REQUEST,"Please check the user body, something error happend",ex),HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(new ExceptionInfo(status,"Malformed JSON",ex),status);
	}
	
	@Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status,
            WebRequest request) {    
        return new ResponseEntity<>(new ExceptionInfo(HttpStatus.METHOD_NOT_ALLOWED,"Http method is not supportive for the request",ex),HttpStatus.METHOD_NOT_ALLOWED);
    }
	
	@ExceptionHandler(UserNotUpdatedException.class)
	protected ResponseEntity<?> handleUserNotUpdatedException( Exception ex, WebRequest req) {
		return new ResponseEntity<>(new ExceptionInfo(HttpStatus.CONFLICT,"User Not saved",ex),HttpStatus.CONFLICT);
	}
	
	
}
