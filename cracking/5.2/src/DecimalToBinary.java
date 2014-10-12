/**
 * Convert decimal number to binary
 * @author hali3
 *
 */
public class DecimalToBinary {
	public static String decimal2Binary(String decimalNum) {
		int dotIndex = decimalNum.indexOf(".");
		// Integer
		if (dotIndex == -1) {
			return convertInt(Integer.parseInt(decimalNum));
		}
		
		String integer = decimalNum.substring(0, dotIndex);
		String decimal = decimalNum.substring(dotIndex);
		String decimalStr = convertDecimal(Double.parseDouble(decimal));
		if (decimalStr.equals("ERROR")) {
			return decimalStr;
		}
		return convertInt(Integer.parseInt(integer)) + "." + decimalStr;
	}
	
	public static String convertInt(int integer) {
		StringBuffer sb = new StringBuffer();
		while (integer != 0) {
			sb.append(integer % 2);
			integer >>= 1;
		}
		return sb.reverse().toString();
	}
	
	public static String convertDecimal(double decimal) {
		StringBuffer sb = new StringBuffer();
		while (decimal != 0) {
			if (sb.length() > 32) {
				return "ERROR";
			}
			decimal *= 2;
			if (decimal >= 1) {
				sb.append("1");
				decimal -= 1;
			} else {
				sb.append("0");
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(DecimalToBinary.decimal2Binary("125"));
	}
}
