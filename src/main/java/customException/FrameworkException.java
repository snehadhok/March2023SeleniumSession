package customException;

public class FrameworkException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameworkException(String mesg) {
		super(mesg);
	}

}