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
	private Operand value = null;
	private ArrayList<Operator> operatorList = null;
	
	/**
	 * Deault operator list
	 */
	public static  final ArrayList<Operator> defaultOperatorList = new ArrayList<Operator>();
	/**
	 * Infix type
	 */
	public static final int INFIX = 0;
	/**
	 * Postfix type
	 */
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
		value = Expression.evaluatePostfix(postfix);
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
			value = Expression.evaluatePostfix(postfix);
		} else if (this.type == Expression.POSTFIX) {
			postfix = Expression.getPostfix(pureExpression);
			infix = Expression.postfixToInfix(postfix);
			value = Expression.evaluatePostfix(postfix);
		} else {
			throw new ExpressionException(ExpressionException.invalidExpressMessage("Unknown type"));
		}
		this.operatorList = Expression.defaultOperatorList;
	}
	
	/**
	 * Constructor
	 * @param expression The expression passed to class. Space will be ignored. Float number allowed
	 * @param type type Expression type. Infix or Postfix
	 * @param operatorList A list of operators
	 */
	public Expression(String expression, int type, ArrayList<Operator> operatorList) {
		this.expression = expression;
		pureExpression = Token.removeIgnoreChars(expression);
		this.type = type;
		if (this.type == Expression.INFIX) {
			infix = Expression.getInfix(pureExpression, operatorList);
			postfix = Expression.infixToPostfix(infix);
			value = Expression.evaluatePostfix(postfix);
			this.operatorList = operatorList;
		} else if (this.type == Expression.POSTFIX) {
			postfix = Expression.getPostfix(pureExpression, operatorList);
			infix = Expression.postfixToInfix(postfix);
			value = Expression.evaluatePostfix(postfix);
			this.operatorList = operatorList;
		} else {
			throw new ExpressionException(ExpressionException.invalidExpressMessage("Unknown type"));
		}
	}
	
	/**
	 * Constructor
	 * @param expression expression The expression passed to class. Space will be ignored. Float number allowed
	 * @param operatorList A list of operators
	 */
	public Expression(String expression, ArrayList<Operator> operatorList) {
		// Remove all the spaces
		this.expression = expression;
		pureExpression = Token.removeIgnoreChars(expression);
		infix = Expression.getInfix(pureExpression, operatorList);
		postfix = Expression.infixToPostfix(infix);
		value = Expression.evaluatePostfix(postfix);
		this.operatorList = operatorList;
	}
	
	/**
	 * Evaluate the stored expression.
	 * @return Double value of expression
	 */
	public Operand evaluate() {
		return value;
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
	 * Convert from string expression to infix token list
	 * @param expression String expression
	 * @param operatorList A list of operators
	 * @return Infix token list
	 */
	public static ArrayList<Token> getInfix(String expression, ArrayList<Operator> operatorList) {
		expression = Token.removeIgnoreChars(expression);
		Tokenizer tokenizer = new Tokenizer(expression, operatorList);
		String[] tokens = tokenizer.getInfixTokens();
		Token previousToken = null;
		ArrayList<Token> tokenList = new ArrayList<Token>();
		
		for (String token : tokens) {
			Token nextToken;
			if (token.equals("(")) {
				if (previousToken == null) {
					nextToken = new Token("(");
				} else {
					switch (previousToken.getType()) {
					case Token.OPERAND:
						throw new ExpressionException(ExpressionException.invalidExpressMessage("\"(\" after operand"));
					case Token.RIGHTBRACE:
						throw new ExpressionException(ExpressionException.invalidExpressMessage("\"(\" after \")\""));
					case Token.OPERATOR:
					case Token.LEFTBRACE:
						nextToken = new Token("(");
						break;
					default:
						throw new ExpressionException(ExpressionException.invalidExpressMessage("unknow token type"));
					}
				}
			} else if (token.equals(")")) {
				if (previousToken == null) {
					nextToken = new Token(")");
				} else {
					switch (previousToken.getType()) {
					case Token.LEFTBRACE:
						throw new ExpressionException(ExpressionException.invalidExpressMessage("\")\" after \"(\""));
					case Token.OPERATOR:
						throw new ExpressionException(ExpressionException.invalidExpressMessage("\")\" after operator"));
					case Token.OPERAND:
					case Token.RIGHTBRACE:
						nextToken = new Token(")");
						break;
					default:
						throw new ExpressionException(ExpressionException.invalidExpressMessage("unknow token type"));
					}
				}
			} else if (tokenizer.isOperator(token)) {
				// Must be a unary operator
				if (previousToken == null) {
					Operator op = tokenizer.getUnary(token);
					if (op == null) {
						throw new ExpressionException(ExpressionException.invalidExpressMessage("leading binary operator"));
					}
					nextToken = new Token(op);
				} else {
					Operator op;
					switch (previousToken.getType()) {
					case Token.OPERAND:
					case Token.RIGHTBRACE:
						op = tokenizer.getBinary(token);
						if (op == null) {
							throw new ExpressionException(ExpressionException.invalidExpressMessage("Unary operator after operand"));
						}
						nextToken = new Token(op);
						break;
					case Token.LEFTBRACE:
					case Token.OPERATOR:
						op = tokenizer.getUnary(token);
						if (op == null) {
							throw new ExpressionException(ExpressionException.invalidExpressMessage("Binary operator after operator"));
						}
						nextToken = new Token(op);
						break;
					default:
						throw new ExpressionException(ExpressionException.invalidExpressMessage("unknow token type"));
					}
				}
			} else {
				Operand operand = new Operand(token);
				if (previousToken == null) {
					nextToken = new Token(operand);
				} else {
					switch (previousToken.getType()) {
					case Token.OPERAND:
						throw new ExpressionException(ExpressionException.invalidExpressMessage("operand after operand"));
					case Token.RIGHTBRACE:
						throw new ExpressionException(ExpressionException.invalidExpressMessage("operand after right brace"));
					case Token.LEFTBRACE:
					case Token.OPERATOR:
						nextToken = new Token(operand);
						break;
					default:
						throw new ExpressionException(ExpressionException.invalidExpressMessage("unknow token type"));
					}
				}
			}
			tokenList.add(nextToken);
			previousToken = nextToken;
		}
		
		Expression.evaluateInfix(tokenList);
		return tokenList;
	}
	
	/**
	 * Get infix token array list from infix string expression.
	 * @param expression String expression
	 * @return Tokenized infix list
	 */
	public static ArrayList<Token> getInfix(String expression) {
		return Expression.getInfix(expression, defaultOperatorList);
	}
	
	/**
	 * Convert from string expression to infix token list
	 * @param expression String expression
	 * @param operatorList A list of operators
	 * @return Postfix token list
	 */
	public static ArrayList<Token> getPostfix(String expression, ArrayList<Operator> operatorList) {
		expression = Token.removeIgnoreChars(expression);
		Tokenizer tokenizer = new Tokenizer(expression, operatorList);
		String[] tokens = tokenizer.getPostfixTokens();
		ArrayList<Token> tokenList = new ArrayList<Token>();
		if (!generateTokenList(tokens, 0, tokenList, operatorList)) {
			throw new ExpressionException(ExpressionException.invalidExpressMessage("Can't generate postfix expression"));
		}
		return tokenList;
	}
	/**
	 * Get postfix token array list from postfix string expression. Delimitor is ','
	 * @param expression Postfix string expression
	 * @return Tokenized postfix list
	 */
	public static ArrayList<Token> getPostfix(String expression) {
		return Expression.getPostfix(expression, defaultOperatorList);
	}
	
	/**
	 * Test if tokens can generate a valid postfix expression
	 * @param tokens Token array
	 * @param start Starting index
	 * @param tokenList Current tokenList
	 * @param operatorList A list of operators
	 * @return True if tokens can generate valid postfix expression. False otherwise.
	 */
	private static boolean generateTokenList(String[] tokens, int start, ArrayList<Token> tokenList, ArrayList<Operator> operatorList) {
		// Processed all tokens, now try to evaluate
		if (start == tokens.length) {
			try {
				Expression.evaluatePostfix(tokenList);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		boolean isOperator = false;
		for (Operator op : operatorList) {
			// This token is an operator
			if (op.getName().equals(tokens[start])) {
				isOperator = true;
				tokenList.add(new Token(op));
				if (generateTokenList(tokens, start + 1, tokenList, operatorList)) {
					return true;
				}
				tokenList.remove(tokenList.size() - 1);
			}
		}
		if (!isOperator) {
			try {
				Operand operand = new Operand(tokens[start]);
				tokenList.add(new Token(operand));
				if (!generateTokenList(tokens, start + 1, tokenList, operatorList)) {
					tokenList.remove(tokenList.size() - 1);
					return false;
				}
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Covert infix string expression to postfix token list
	 * @param expression Infix string expression
	 * @param operatorList A list of operators
	 * @return Postfix token list
	 */
	public static ArrayList<Token> infixToPostfix(String expression, ArrayList<Operator> operatorList) {
		ArrayList<Token> infixList = Expression.getInfix(expression, operatorList);
		return Expression.infixToPostfix(infixList);
	}
	
	/**
	 * Convert string infix to postfix tokenized list.
	 * @param expression Expression to be converted
	 * @return postfix tokenized list
	 */
	public static ArrayList<Token> infixToPostfix(String expression) {
		return Expression.infixToPostfix(expression, defaultOperatorList);
	}
	
	/**
	 * Convert tokenized infix to postfix tokenized list.
	 * @param expression Expression to be converted
	 * @return postfix tokenized list
	 */
	public static ArrayList<Token> infixToPostfix(ArrayList<Token> expression) {
		Stack<Token> operatorStack = new Stack<Token>();
		ArrayList<Token> postfixList = new ArrayList<Token>();
		
		for (Token token : expression) {
			if (token.getType() == Token.OPERAND) {
				postfixList.add(token);
			} else if (token.getType() == Token.LEFTBRACE) {
				operatorStack.push(token);
			} else if (token.getType() == Token.OPERATOR) {
				while (operatorStack.size() > 0) {
					Token topToken = operatorStack.peek();
					if (topToken.getType() == Token.OPERAND) {
						throw new ExpressionException("Operand shouldn't be in operator stack");
					} else if (topToken.getType() == Token.LEFTBRACE || topToken.getType() == Token.RIGHTBRACE) {
						break;
					} else if (topToken.getType() == Token.OPERATOR) {
						if (token.getOperator().compareTo(topToken.getOperator()) > 0) {
							break;
						} else if (token.getOperator().compareTo(topToken.getOperator()) < 0) {
							topToken = operatorStack.pop();
							postfixList.add(topToken);
						} else {
							if (!topToken.getOperator().isLeftAssociative()) {
								break;
							} else {
								topToken = operatorStack.pop();
								postfixList.add(topToken);
							}
						}
					} else {
						throw new ExpressionException("Unknow token in operator stack");
					}
				}
				operatorStack.push(token);
			} else if (token.getType() == Token.RIGHTBRACE) {
				boolean found = false;
				while (operatorStack.size() > 0 && found == false) {
					Token topToken = operatorStack.pop();
					if (topToken.getType() == Token.LEFTBRACE) {
						found = true;
					} else if (topToken.getType() == Token.OPERATOR){
						postfixList.add(topToken);
					} else {
						throw new ExpressionException("Invalid token in operator stack");
					}
				}
				if (!found) {
					throw new ExpressionException("Invalid infix expression: unmatched bracket");
				}
			} else {
				throw new ExpressionException("Unknown token in expression: \"" + token.getName() + "\"");
			}
		}
		
		while (operatorStack.size() > 0) {
			Token topToken = operatorStack.pop();
			if (topToken.getType() == Token.LEFTBRACE) {
				throw new ExpressionException("Invalid infix expression: unmatched bracket");
			} else if (topToken.getType() == Token.OPERAND) {
				throw new ExpressionException("Operand in operator stack");
			} else if (topToken.getType() == Token.OPERATOR) {
				postfixList.add(topToken);
			} else {
				throw new ExpressionException("Unknown token in expression: \"" + topToken.getName() + "\"");
			}
		}
		return postfixList;
	}
	
	/**
	 * Convert string infix to postfix tokenized list.
	 * @param expression String expression Expression to be converted
	 * @param operatorList A list of operators
	 * @return Infix token list
	 */
	public static ArrayList<Token> postfixToInfix(String expression, ArrayList<Operator> operatorList) {
		ArrayList<Token> postfixList = Expression.getPostfix(expression, operatorList);
		return Expression.postfixToInfix(postfixList);
	}
	
	/**
	 * Convert string postfix to tokenized infix.
	 * @param expression Expression to be converted
	 * @return infix
	 */
	public static ArrayList<Token> postfixToInfix(String expression) {
		return Expression.postfixToInfix(expression, Expression.defaultOperatorList);
	}
	
	/**
	 * Convert tokenized postfix to tokenized infix.
	 * @param expression Expression to be converted
	 * @return infix
	 */
	public static ArrayList<Token> postfixToInfix(ArrayList<Token> expression) {
		Stack<ArrayList<Token>> stack = new Stack<ArrayList<Token>>();
		for (Token token : expression) {
			if (token.getType() == Token.OPERAND) {
				ArrayList<Token> tokenList = new ArrayList<Token>();
				tokenList.add(token);
				stack.push(tokenList);
			} else if (token.getType() == Token.OPERATOR) {
				if (token.getOperator().isBinary()) {
					if (stack.size() < 2) {
						throw new ExpressionException("Invalid expression: too few operands");
					}
					ArrayList<Token> rightOperands = stack.pop();
					ArrayList<Token> leftOperands = stack.pop();
					boolean needBracket = false;
					boolean inBracket = false;
					for (Token t : leftOperands) {
						if (t.getType() == Token.OPERATOR && !inBracket && token.getOperator().compareTo(t.getOperator()) > 0) {
							needBracket = true;
							break;
						} else if (t.getType() == Token.LEFTBRACE) {
							inBracket = true;
						} else if (t.getType() == Token.RIGHTBRACE) {
							inBracket = false;
						}
					}
					if (needBracket) {
						leftOperands.add(new Token(")"));
						leftOperands.add(0, new Token("("));
					}
					needBracket = false;
					inBracket = false;
					for (Token t : rightOperands) {
						if (t.getType() == Token.OPERATOR && !inBracket && token.getOperator().compareTo(t.getOperator()) > 0) {
							needBracket = true;
							break;
						} else if (t.getType() == Token.LEFTBRACE) {
							inBracket = true;
						} else if (t.getType() == Token.RIGHTBRACE) {
							inBracket = false;
						}
					}
					if (needBracket) {
						rightOperands.add(new Token(")"));
						rightOperands.add(0, new Token("("));
					}
					ArrayList<Token> newList = new ArrayList<Token>();
					newList.addAll(leftOperands);
					newList.add(token);
					newList.addAll(rightOperands);
					stack.push(newList);
				} else if (token.getOperator().isUnary()){
					if (stack.size() < 1) {
						throw new ExpressionException("Invalid expression: too few operands");
					}
					ArrayList<Token> leftOperands = stack.pop();
					boolean needBracket = false;
					boolean inBracket = false;
					for (Token t : leftOperands) {
						if (t.getType() == Token.OPERATOR && !inBracket && token.getOperator().compareTo(t.getOperator()) > 0) {
							needBracket = true;
							break;
						} else if (t.getType() == Token.LEFTBRACE) {
							inBracket = true;
						} else if (t.getType() == Token.RIGHTBRACE) {
							inBracket = false;
						}
					}
					if (needBracket) {
						leftOperands.add(new Token(")"));
						leftOperands.add(0, new Token("("));
					}
					ArrayList<Token> newList = new ArrayList<Token>();
					newList.add(0, token);
					newList.addAll(leftOperands);
					stack.push(newList);
				}
			} else if (token.getType() == Token.LEFTBRACE || token.getType() == Token.RIGHTBRACE) {
				throw new ExpressionException("Invalid expression: bracket in postfix expression");
			} else {
				throw new ExpressionException("Unknown token type");
			}
		}
		
		if (stack.size() != 1) {
			throw new ExpressionException("Invalid expression");
		}
		return stack.pop();
	}
	
	/**
	 * Evaluate infix string expression with operator list
	 * @param expression Infix string expression (default)
	 * @param operatorList A list of operators
	 * @return Operand
	 */
	public static Operand evaluateInfix(String expression, ArrayList<Operator> operatorList) {
		return evaluate(expression, INFIX, operatorList);
	}
	
	/**
	 * Evaluate infix string expression
	 * @param expression Expression to be evaluated
	 * @return Operand
	 */
	public static Operand evaluateInfix(String expression) {
		return evaluate(expression, INFIX, defaultOperatorList);
	}
	
	/**
	 * Evaluate postfix expression with operator list
	 * @param expression Expression to be evaluated
	 * @param operatorList Operator list
	 * @return Operand
	 */
	public static Operand evaluatePostfix(String expression, ArrayList<Operator> operatorList) {
		return evaluate(expression, POSTFIX, operatorList);
	}
	
	/**
	 * Evaluate postfix expression
	 * @param expression Expression to be evaluated
	 * @return Operand
	 */
	public static Operand evaluatePostfix(String expression) {
		return evaluate(expression, POSTFIX, Expression.defaultOperatorList);
	}
	
	/**
	 * Evaluate string expression based on type
	 * @param expression String expression to be evaluated
	 * @param type Expressoin type. Infix or postfix.
	 * @param operatorList A list of operators.
	 * @return Operand
	 */
	private static Operand evaluate(String expression, int type, ArrayList<Operator> operatorList) {
		String postfix = Token.removeIgnoreChars(expression);
		if (type == INFIX) {
			ArrayList<Token> postfixList = Expression.infixToPostfix(postfix, operatorList);
			return Expression.evaluatePostfix(postfixList);
		} else if (type == POSTFIX) {
			ArrayList<Token> postfixList = Expression.getPostfix(expression, operatorList);
			return Expression.evaluatePostfix(postfixList);
		} else {
			throw new ExpressionException("Invalid expression type");
		}
	}
	
	/**
	 * Evaluate expression by given type
	 * @param expression Expression to be evaluated
	 * @param type Expression type, infix or postfix
	 * @return Operand
	 * @throws ExpressionException 
	 */
	public static Operand evaluate(String expression, int type) {
		return Expression.evaluate(expression, type, defaultOperatorList);
	}
	
	/**
	 * Evaluate infix token list
	 * @param infix Infix token list
	 * @return Operand
	 */
	public static Operand evaluateInfix(ArrayList<Token> infix) {
		return Expression.evaluatePostfix(Expression.infixToPostfix(infix));
	}
	
	/**
	 * Evaluate postfix expression from token list
	 * @param postfix Tokenized list
	 * @return Postfix expression value
	 */
	public static Operand evaluatePostfix(ArrayList<Token> postfix) {
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
						throw new ExpressionException("Invalid expression: too few operands");
					}
				} else if (token.getOperator().isUnary()) {
					try {
						Token t1 = stack.pop();
						Token t = new Token(token.getOperator().evaluate(t1.getOperand()));
						stack.push(t);
					} catch (Exception e) {
						throw new ExpressionException("Invalid expression");
					}
				} else {
					throw new ExpressionException("Invalid postfix expression");
				}
			} else {
				throw new ExpressionException("Invalid token in postfix expressioin");
			}
		}
		if (stack.size() != 1) {
			throw new ExpressionException("Invalid postfix expression");
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
		try {
			Expression.evaluateInfix(expression);
		} catch (ExpressionException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Check whether an expression is a valid postfix expression
	 * 
	 * @param expression Expression to be checked
	 * @return True if it is valid postfix expression, otherwise false
	 */
	public static boolean isPostfix(String expression) {
		try {
			Expression.evaluatePostfix(expression);
		} catch (ExpressionException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Add default operators
	 */
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
		minusOp.addEvaluator(new Evaluator() {
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
		multiplyOp.addEvaluator(new Evaluator() {
			@Override
			public Operand binaryAction(Operand operand1, Operand operand2) {
				return new Operand(operand1.getValue() * operand2.getValue());
			}

			@Override
			public Operand unaryAction(Operand operand) {
				return null;
			}
			
		});
		Operator divideOp = new Operator('/', false, true, 1, true, "Divide operator");
		divideOp.addEvaluator(new Evaluator() {
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
		modOp.addEvaluator(new Evaluator() {
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
		powerOp.addEvaluator(new Evaluator() {
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
		positiveOp.addEvaluator(new Evaluator() {
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
		negtiveOp.addEvaluator(new Evaluator() {
			@Override
			public Operand binaryAction(Operand operand1, Operand operand2) {
				return null;
			}

			@Override
			public Operand unaryAction(Operand operand) {
				return new Operand(operand.getValue() * -1);
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
