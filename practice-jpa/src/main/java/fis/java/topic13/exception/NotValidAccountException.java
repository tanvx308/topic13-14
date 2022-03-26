package fis.java.topic13.exception;

public class NotValidAccountException extends AppException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotValidAccountException(String code, String message) {
		super(code, message);
	}
}
