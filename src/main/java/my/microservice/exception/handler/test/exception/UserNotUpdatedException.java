package my.microservice.exception.handler.test.exception;

public class UserNotUpdatedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public UserNotUpdatedException() {
		super();
	}
	
	public UserNotUpdatedException(String message) {
		super(message);
	}

	public UserNotUpdatedException(Throwable cause) {
		super(cause);
	}
	
	public UserNotUpdatedException(String message, Throwable cause) {
		super(message,cause);
	}
	
}
