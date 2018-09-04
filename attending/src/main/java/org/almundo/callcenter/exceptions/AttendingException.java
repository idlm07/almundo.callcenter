package org.almundo.callcenter.exceptions;

/**
 * Exception Class for Call center
 * Attending system.
 * @author IvanLemus
 *
 */
public class AttendingException extends Exception {

	/**serial id*/
	private static final long serialVersionUID = -863402658018760637L;

	/**
	 * Empty Constructor
	 */
	public AttendingException() {}
	
	/**
	 * Basic Constructor
	 * @param message
	 */
	public AttendingException(String message) {
        super(message);
    }

	@Override
	public String toString() {
		return "AttendingException [getMessage()=" + getMessage()
				+ ", getCause()=" + getCause() + "]";
	}
}
