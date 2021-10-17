package exceptions;

public class DayAndIDException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DayAndIDException() {
		super("El penultimo numero del documento no coresponde al dia");
	}

}
