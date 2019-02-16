package my.microservice.exception.handler.test.exception;

public class UserValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public UserValidationException() {
		super();
	}
	
	public UserValidationException( String message ) {
		super(message);
	}

	public UserValidationException(Throwable cause) {
		super(cause);
	}
	
	public UserValidationException( String message, Throwable cause ) {
		super(message,cause);
	}
	
	@Override
	public String toString() {
		return "UserValidationException [message=" + message + "]";
	}
	
}
