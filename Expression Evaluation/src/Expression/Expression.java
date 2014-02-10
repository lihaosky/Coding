package Expression;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Expression Class
 * 
 * Evaluate an expression.
 * Operators:
 * +, -: Left associative, precedence 1
 * *, /: Left associative, precedence 2
 * ^   : right associative, precedence 3
 * 
 * ()  : not operators
 * 
 * 1. Produce postfix expression from infix input and output evaluation. 
 * If the expression is invalid, output syntax error.
 * 
 * 2. Try to construct and output abstract syntax tree (AST)
 * 
 * Algorithm:
 * 1. Read character C from expression E (Ignore all the spaces)
 * 2. if C is 
 *    2.1 an operand: output to output queue Q
 *    2.2 an operator:
 *        WHILE there is an operator O in stack and if 
 *              2.2.1 O has lower precedence: put C to S, break
 *              2.2.2 O has equal precedence 
 *                      2.2.2.1   C is left associative: pop O and put it to Q
 *                      2.2.2.2   C is right associative: put C to S, break
 *              2.2.3 O has higher precedence: pop O and put it to Q
 *    2.3 (: put it to S
 *    2.4 ): until find ( in S, pop operator to Q
 *    
 * 3. Pop everything to Q, if encounter (, it's invalid syntax
 * 
 * @author lihaosky
 *
 */

public class Expression {
	private String expression;
	private String pureExpression;
	private ArrayList<Token> infix = null;
	private ArrayList<Token> postfix = null;
	private int type = Expression.INFIX;
	private String value = "";
	private ArrayList<Operator> operatorList = null;
	
	public static  final ArrayList<Operator> defaultOperatorList = new ArrayList<Operator>();
	public static final int INFIX = 0;
	public static final int POSTFIX = 1;
	
	static {
		Expression.addDefaultOperators();
	}
	
	/**
	 * Constructor for expression. Pass the expression to be construct and evaluated.
	 * Default type is infix.
	 * 
	 * @param expression The expression passed to class. Space will be ignored. Float number allowed
	 * @throws ExpressionException 
	 */
	public Expression(String expression) {
		// Remove all the spaces
		this.expression = expression;
		pureExpression = Token.removeIgnoreChars(expression);
		infix = Expression.getInfix(pureExpression);
		postfix = Expression.infixToPostfix(infix);
		value = Expression.evaluatePostfix(postfix) + "";
		this.operatorList = Expression.defaultOperatorList;
	}
	
	/**
	 * Constructor for expression. Pass the expression to be construct and evaluated.
	 * 
	 * @param expression The expression passed to class. Space will be ignored. Float number allowed
	 * @param type Expression type. Infix or Postfix
	 * @throws ExpressionException
	 */
	public Expression(String expression, int type) {
		this.expression = expression;
		pureExpression = Token.removeIgnoreChars(expression);
		this.type = type;
		if (this.type == Expression.INFIX) {
			infix = Expression.getInfix(pureExpression);
			postfix = Expression.infixToPostfix(infix);
			value = Expression.evaluatePostfix(postfix) + "";
		} else if (this.type == Expression.POSTFIX) {
			postfix = Expression.getPostfix(pureExpression);
			infix = Expression.postfixToInfix(postfix);
			value = Expression.evaluatePostfix(postfix) + "";
		} else {
			throw new ExpressionException("Invalid expression type");
		}
		this.operatorList = Expression.defaultOperatorList;
	}
	
	public Expression(String expression, int type, ArrayList<Operator> operatorList) {
		this.expression = expression;
		pureExpression = Token.removeIgnoreChars(expression);
		this.type = type;
		if (this.type == Expression.INFIX) {
			infix = Expression.getInfix(pureExpression);
			postfix = Expression.infixToPostfix(infix);
			value = Expression.evaluatePostfix(postfix) + "";
			this.operatorList = operatorList;
		} else if (this.type == Expression.POSTFIX) {
			postfix = Expression.getPostfix(pureExpression);
			infix = Expression.postfixToInfix(postfix);
			value = Expression.evaluatePostfix(postfix) + "";
			this.operatorList = operatorList;
		} else {
			throw new ExpressionException("Invalid expression type");
		}
	}
	
	public Expression(String expression, ArrayList<Operator> operatorList) {
		// Remove all the spaces
		this.expression = expression;
		pureExpression = Token.removeIgnoreChars(expression);
		infix = Expression.getInfix(pureExpression);
		postfix = Expression.infixToPostfix(infix);
		value = Expression.evaluatePostfix(postfix) + "";
		this.operatorList = operatorList;
	}
	
	/**
	 * Evaluate the stored expression.
	 * @return Double value of expression
	 */
	public double evaluate() {
		return Double.parseDouble(value);
	}
	
	/**
	 * Get original expression. 
	 * @return Original passed in expression
	 */
	public String getExpression() {
		return expression;
	}
	
	/**
	 * Get tokenized infix expression.
	 * @return Tokenized infix expression
	 */
	public ArrayList<Token> getInfix() {
		return infix;
	}
	
	/**
	 * Get tokenized postfix expression.
	 * @return Tokenized postfix expression
	 */
	public ArrayList<Token> getPostfix() {
		return postfix;
	}
	
	/**
	 * Get infix token array list from infix string expression.
	 * @param expression String expression
	 * @return Tokenized infix list
	 */
	public static ArrayList<Token> getInfix(String expression) {
		///
		/// To be done
		///
		return new ArrayList<Token>();
	}
	
	/**
	 * Get postfix token array list from postfix string expression. Delimitor is ','
	 * @param expression Postfix string expression
	 * @return Tokenized postfix list
	 */
	public static ArrayList<Token> getPostfix(String expression) {
		/// 
		/// To be done
		///
		return new ArrayList<Token>();
	}
	
	/**
	 * Convert string infix to postfix tokenized list.
	 * @param String expression Expression to be converted
	 * @return postfix tokenized list
	 */
	public static ArrayList<Token> infixToPostfix(String expression) {
		///
		/// To be done
		///
		return new ArrayList<Token>();
	}
	
	/**
	 * Convert tokenized infix to postfix tokenized list.
	 * @param expression Expression to be converted
	 * @return postfix tokenized list
	 */
	public static ArrayList<Token> infixToPostfix(ArrayList<Token> expression) {
		///
		/// To be done
		///
		return new ArrayList<Token>();
	}
	
	/**
	 * Convert string postfix to tokenized infix.
	 * @param String expression Expression to be converted
	 * @return infix
	 */
	public static ArrayList<Token> postfixToInfix(String expression) {
		/// 
		/// TO BE DONE
		///
		return new ArrayList<Token>();
	}
	
	/**
	 * Convert tokenized postfix to tokenized infix.
	 * @param Tokenized expression Expression to be converted
	 * @return infix
	 */
	public static ArrayList<Token> postfixToInfix(ArrayList<Token> expression) {
		/// 
		/// TO BE DONE
		///
		return new ArrayList<Token>();
	}
	
	/**
	 * Evaluate expression, default type is infix
	 * @param expression Expression to be evaluated
	 * @return
	 * @throws ExpressionException 
	 */
	public static Operand evaluate(String expression) throws ExpressionException {
		return evaluate(expression, INFIX);
	}
	
	/**
	 * Evaluate expression by given type
	 * @param expression Expression to be evaluated
	 * @param type Expression type, infix or postfix
	 * @return
	 * @throws ExpressionException 
	 */
	public static Operand evaluate(String expression, int type) {
		String postfix = Token.removeIgnoreChars(expression);
		if (type == INFIX) {
			ArrayList<Token> postfixList = Expression.infixToPostfix(postfix);
			return Expression.evaluatePostfix(postfixList);
		} else if (type == POSTFIX) {
			return Expression.evaluatePostfix(postfix);
		} else {
			throw new ExpressionException("Invalid expression type");
		}
	}
	
	/**
	 * Evaluate postfix expression
	 * @param postfix Postfix expression
	 * @return Postfix expression value
	 * @throws ExpressionException 
	 */
	private static Operand evaluatePostfix(String postfix) {
		ArrayList<Token> postfixList = Expression.getPostfix(postfix);
		return Expression.evaluatePostfix(postfixList);
	}
	
	/**
	 * Evaluate postfix expression from token list
	 * @param postfix Tokenized list
	 * @return Postfix expression value
	 */
	private static Operand evaluatePostfix(ArrayList<Token> postfix) {
		Stack<Token> stack = new Stack<Token>();
		for (Token token : postfix) {
			// Operand, put to stack
			if (token.getType() == Token.OPERAND) {
				stack.push(token);
			} else if (token.getType() == Token.OPERATOR) {
				// Binary operator, pop two operands
				if (token.getOperator().isBinary()) {
					try {
						Token t1 = stack.pop();
						Token t2 = stack.pop();
						Token t = new Token(token.getOperator().evaluate(t2.getOperand(), t1.getOperand()));
						stack.push(t);
					} catch (Exception e) {
						throw new ExpressionException("Invalid postfix");
					}
				} else if (token.getOperator().isUnary()) {
					try {
						Token t1 = stack.pop();
						Token t = new Token(token.getOperator().evaluate(t1.getOperand()));
						stack.push(t);
					} catch (Exception e) {
						throw new ExpressionException("Invalid postfix");
					}
				} else {
					throw new ExpressionException("Invalid postfix");
				}
			} else {
				throw new ExpressionException("Invalid token");
			}
		}
		if (stack.size() != 1) {
			throw new ExpressionException("Invalid postfix");
		}
		return stack.pop().getOperand();
	}
	
	/**
	 * Check whether an expression is a valid infix expression
	 * 
	 * @param expression Expression to be checked
	 * @return True if it is valid infix expression, otherwise false
	 */
	public static boolean isInfix(String expression) {
		/// 
		/// TO BE DONE
		///
		return true;
	}
	
	/**
	 * Check whether an expression is a valid postfix expression
	 * 
	 * @param expression Expression to be checked
	 * @return True if it is valid postfix expression, otherwise false
	 */
	public static boolean isPostfix(String expression) {
		///
		/// TO BE DONE
		///
		return true;
	}
	
	private static void addDefaultOperators() {
		Operator addOp = new Operator('+', false, true, 0, true, "Add operator");
		addOp.addEvaluator(new Evaluator() {
			@Override
			public Operand binaryAction(Operand operand1, Operand operand2) {
				return new Operand(operand1.getValue() + operand2.getValue());
			}

			@Override
			public Operand unaryAction(Operand operand) {
				return null;
			}
			
		});
		Operator minusOp = new Operator('-', false, true, 0, true, "Subtract operator");
		addOp.addEvaluator(new Evaluator() {
			@Override
			public Operand binaryAction(Operand operand1, Operand operand2) {
				return new Operand(operand1.getValue() - operand2.getValue());
			}

			@Override
			public Operand unaryAction(Operand operand) {
				return null;
			}
			
		});
		Operator multiplyOp = new Operator('*', false, true, 1, true, "Multiply operator");
		addOp.addEvaluator(new Evaluator() {
			@Override
			public Operand binaryAction(Operand operand1, Operand operand2) {
				return new Operand(operand1.getValue() - operand2.getValue());
			}

			@Override
			public Operand unaryAction(Operand operand) {
				return null;
			}
			
		});
		Operator divideOp = new Operator('/', false, true, 1, true, "Divide operator");
		addOp.addEvaluator(new Evaluator() {
			@Override
			public Operand binaryAction(Operand operand1, Operand operand2) {
				return new Operand(operand1.getValue() / operand2.getValue());
			}

			@Override
			public Operand unaryAction(Operand operand) {
				return null;
			}
			
		});
		Operator modOp = new Operator('%', false, true, 2, true, "Mod operator");
		addOp.addEvaluator(new Evaluator() {
			@Override
			public Operand binaryAction(Operand operand1, Operand operand2) {
				return new Operand(operand1.getValue() % operand2.getValue());
			}

			@Override
			public Operand unaryAction(Operand operand) {
				return null;
			}
			
		});
		Operator powerOp = new Operator('^', false, true, 3, false, "Power operator");
		addOp.addEvaluator(new Evaluator() {
			@Override
			public Operand binaryAction(Operand operand1, Operand operand2) {
				return new Operand(Math.pow(operand1.getValue(), operand2.getValue()));
			}

			@Override
			public Operand unaryAction(Operand operand) {
				return null;
			}
			
		});
		Operator positiveOp = new Operator('+', true, false, 3, true, "Positive operator");
		addOp.addEvaluator(new Evaluator() {
			@Override
			public Operand binaryAction(Operand operand1, Operand operand2) {
				return null;
			}

			@Override
			public Operand unaryAction(Operand operand) {
				return new Operand(operand.getValue());
			}
			
		});
		Operator negtiveOp = new Operator('-', true, false, 3, true, "Negative operator");
		addOp.addEvaluator(new Evaluator() {
			@Override
			public Operand binaryAction(Operand operand1, Operand operand2) {
				return null;
			}

			@Override
			public Operand unaryAction(Operand operand) {
				return new Operand(operand.getValue());
			}
			
		});
		Expression.defaultOperatorList.add(addOp);
		Expression.defaultOperatorList.add(minusOp);
		Expression.defaultOperatorList.add(multiplyOp);
		Expression.defaultOperatorList.add(divideOp);
		Expression.defaultOperatorList.add(powerOp);
		Expression.defaultOperatorList.add(positiveOp);
		Expression.defaultOperatorList.add(negtiveOp);
		Expression.defaultOperatorList.add(modOp);
	}
	
}
