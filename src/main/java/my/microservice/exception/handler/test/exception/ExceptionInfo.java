package my.microservice.exception.handler.test.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionInfo {

	@JsonProperty
	private HttpStatus status;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;

	@JsonProperty
	private String message;
	
	@JsonProperty
	private String debugMessage;
	
	private ExceptionInfo() {
		timestamp = LocalDateTime.now();
	}
	
	public ExceptionInfo(HttpStatus status) {
		this();
		this.status = status;
	}
	
	public ExceptionInfo(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.message = " Unexpected error ";
		this.debugMessage = ex.getLocalizedMessage();
	}
	
	public ExceptionInfo(HttpStatus status,String message, Throwable ex) {
		this();
		this.status = status;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}
}
