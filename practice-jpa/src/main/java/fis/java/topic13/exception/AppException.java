package fis.java.topic13.exception;

public class AppException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8737749373068249957L;
	private String code;
	
	public AppException(String code, String message) {
		super(message);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
