package Expression;

public class Operand {
	private String operand = "";
	private double value;
	
	public Operand(String operand) {
		try {
			value = Double.parseDouble(operand);
			this.operand = operand;
		} catch (Exception e) {
			throw new ExpressionException("Invalid operand");
		}
	}
	
	public Operand(double value) {
		this.value = value;
		operand = value + "";
	}
	
	public double getValue() {
		return value;
	}
	
	public String getStringValue() {
		return operand;
	}
}
