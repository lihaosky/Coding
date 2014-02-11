package Expression;

import java.util.ArrayList;


/**
 * Operator class
 * @author lihaosky
 *
 */
public class Operator implements Comparable<Operator> {
	private static final int UNARY = 0x1;
	private static final int BINARY = 0x2;
	
	public static ArrayList<String> validName = new ArrayList<String>();
	
	private int type = 0x0;
	private boolean associativity = true;
	private int precedence = 0;
	private String name = "";
	private String description = "";
	private Evaluator evaluator = null;
	
	static {
		validName.add("+");
		validName.add("-");
		validName.add("*");
		validName.add("/");
		validName.add("|");
		validName.add("^");
		validName.add("%");
		validName.add("&");
	}
	
	/**
	 * Operator constructor.
	 * @param name Operator name
	 * @param isUnary If operator is unary
	 * @param isBinary If operator is binary
	 * @param precedence Operator's precedence. Integer. Precedence higher with larger number
	 * @param isLeft If is left associativity
	 * @param description Description of operator
	 * @throws ExpressionException 
	 */
	public Operator(char name, boolean isUnary, boolean isBinary, int precedence, boolean isLeft, String description) {
		this.name = name + "";
		if (!validName.contains(this.name)) {
			throw new ExpressionException("Invalid operator");
		}
		if (isUnary) {
			type |= UNARY;
		}
		if (isBinary) {
			type |= BINARY;
		}
		this.precedence = precedence;
		this.associativity = isLeft;
		if (description != null) {
			this.description = description;
		}
	}
	
	/**
	 * Operator constructor. Default associativity is left.
	 * @param name Operator name
	 * @param isUnary If operator is unary
	 * @param isBinary If operator is binary
	 * @param precedence Operator's precedence. Integer. Precedence higher with larger number
	 * @throws ExpressionException 
	 */
	public Operator(char name, boolean isUnary, boolean isBinary, int precedence) {
		this(name, isUnary, isBinary, precedence, true, (String)null);
	}
	
	/**
	 * Operator constructor. Default associativity is left.
	 * @param name Operator name
	 * @param isUnary If operator is unary
	 * @param isBinary If operator is binary
	 * @param precedence Operator's precedence. Integer. Precedence higher with larger number
	 * @param isLeft If is left associativity
	 * @throws ExpressionException 
	 */
	public Operator(char name, boolean isUnary, boolean isBinary, int precedence, boolean isLeft) {
		this(name, isUnary, isBinary, precedence, isLeft, (String)null);
	}
	
	/**
	 * Operator constructor. Default associativity is left.
	 * @param name Operator name
	 * @param isUnary If operator is unary
	 * @param isBinary If operator is binary
	 * @param precedence Operator's precedence. Integer. Precedence higher with larger number
	 * @param description Operator description
	 * @throws ExpressionException 
	 */
	public Operator(char name, boolean isUnary, boolean isBinary, int precedence, String description) {
		this(name, isUnary, isBinary, precedence, true, description);
	}
	
	/**
	 * If this is unary operator
	 * @return
	 */
	public boolean isUnary() {
		return (type & UNARY) != 0;
	}
	
	/**
	 * If this is binary operator
	 * @return
	 */
	public boolean isBinary() {
		return (type & BINARY) != 0;
	}
	
	/**
	 * If this is left associative
	 * @return
	 */
	public boolean isLeftAssociative() {
		return this.associativity;
	}
	
	/**
	 * Get operator name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get precedence
	 * @return
	 */
	public int getPrecedence() {
		return precedence;
	}
	
	/**
	 * Get description
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Add an evaluator
	 * @param Evaluator
	 */
	public void addEvaluator(Evaluator evaluator) {
		this.evaluator = evaluator;
	}
	
	/**
	 * Evaluate binary operation
	 * @param operand1 First operand to be evaluated
	 * @param operand2 Second operand to be evaluated
	 * @return Value
	 */
	public Operand evaluate(Operand operand1, Operand operand2) {
		if (evaluator == null) {
			throw new ExpressionException("Unknown evaluator");
		}
		if (operand1 == null || operand2 == null) {
			throw new ExpressionException("Invalid operand");
		}
		if (!isBinary()) {
			throw new ExpressionException("Binary operation not supported");
		}
		return evaluator.binaryAction(operand1, operand2);
	}
	
	/**
	 * Evaluate unary operation
	 * @param operand Operand to be evaluated
	 * @return Value
	 * @throws ExpressionException
	 */
	public Operand evaluate(Operand operand) {
		if (evaluator == null) {
			throw new ExpressionException("Unknown evaluator");
		}
		if (operand == null) {
			throw new ExpressionException("Invalid operand");
		}
		if (!isUnary()) {
			throw new ExpressionException("Unary operation not supported");
		}
		return evaluator.unaryAction(operand);
	}
	
	/**
	 * Compare precedence
	 */
	public int compareTo(Operator o) {
		return this.precedence - o.precedence;
	}
	
	@Override
	public boolean equals(Object o) {
		Operator op = (Operator)o;
		return this.name.equals(op.name);
	}
}
	
