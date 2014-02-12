package Expression;

/**
 * Expression Exception class.
 * Provide runtime exception.
 * @author hali3
 *
 */
public class ExpressionException extends RuntimeException {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -30090727476782655L;
	
	/**
	 * Constructor
	 */
	public ExpressionException() {
		super();
	}
	/**
	 * Constructor
	 * @param message Exception message
	 */
	public ExpressionException(String message) {
		super(message);
	}
	
	/**
	 * Invalid expression message
	 * @param msg Message
	 * @return Constructed message
	 */
	public static String invalidExpressMessage(String msg) {
		return "Invalid expression: " + msg;
	}
	
	/**
	 * Invalid expression message
	 * @return Default message
	 */
	public static String invalidExpressMessage() {
		return "Invalid expression";
	}
}
