package exceptions;

public class Under18YearsOldException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Under18YearsOldException() {
		super("No pueden ingresar personas menores de edad");
	}

}
