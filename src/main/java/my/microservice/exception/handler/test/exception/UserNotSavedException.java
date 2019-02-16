package my.microservice.exception.handler.test.exception;

public class UserNotSavedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public UserNotSavedException() {
		super();
	}
	
	public UserNotSavedException(String message) {
		super(message);
	}

	public UserNotSavedException(Throwable cause) {
		super(cause);
	}
	
	public UserNotSavedException(String message, Throwable cause) {
		super(message,cause);
	}
	
}
