package Expression;

/**
 * Evaluator interface. Provided callback function for operator.
 * @author lihaosky
 *
 */
public interface Evaluator {
	/**
	 * Binary operation
	 * @param operand1 First operand
	 * @param operand2 Second operand
	 * @return Value after evaluation
	 */
	public Operand binaryAction(Operand operand1, Operand operand2);
	
	/**
	 * Unary operation
	 * @param operand Operand
	 * @return Value after evaluation
	 */
	public Operand unaryAction(Operand operand);
}
