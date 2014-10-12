/**
 * Swap odd and even position bit
 * @author hali3
 *
 */
public class SwapBit {
	public static int swap(int a) {
		return (a & 0xaaaaaaaa) >> 1 & (a & 0x55555555) << 1;
	}
	
	public static void main(String[] args) {
		
	}
}
