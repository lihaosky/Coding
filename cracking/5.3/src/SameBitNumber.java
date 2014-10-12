/**
 * Find 
 * @author hali3
 *
 */
public class SameBitNumber {
	public static int bitsNumConvert(int a, int b) {
		int c = a ^ b;
		int count = 0;
		while (c != 0) {
			if ((c & 1) == 1) {
				count++;
			}
			c >>= 1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(bitsNumConvert(4, 10));
	}
}
