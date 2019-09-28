/**
 * 
 */
package ml.bootcode.exceptions;

/**
 * @author sunnyb
 *
 */
public class ApiException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	/**
	 * 
	 */
	public ApiException() {
	}

	/**
	 * @param message
	 */
	public ApiException(String message) {
		this.message = message;
	}

	/**
	 * @return the message
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
