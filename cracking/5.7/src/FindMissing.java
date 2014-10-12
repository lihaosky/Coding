import java.util.ArrayList;

/**
 * Find missing integer given can only access bit
 * @author hali3
 *
 */
class BitInteger {
	public int number;
	public BitInteger(int n) {
		number = n;
	}
	
	public int fetch(int pos) {
		return (number >> pos) & 1;
	}
}
public class FindMissing {
	public static int findMissing(ArrayList<BitInteger> array) {
		return findMissing(array, 0);
	}
	
	public static int findMissing(ArrayList<BitInteger> array, int pos) {
		if (pos > 32) {
			return 0;
		}
		ArrayList<BitInteger> oddArray = new ArrayList<BitInteger>();
		ArrayList<BitInteger> evenArray = new ArrayList<BitInteger>();
		
		for (BitInteger i : array) {
			System.out.println("Number: " + i.number + " pos: " + pos + " bit: " + i.fetch(pos));
			if (i.fetch(pos) == 0) {
				oddArray.add(i);
			} else {
				evenArray.add(i);
			}
		}
		
		if (oddArray.size() <= evenArray.size()) {
			return findMissing(evenArray, pos + 1) << 1 | 0;
		} 
		return findMissing(evenArray, pos + 1) << 1 | 1;
	}
	
	public static void main(String[] args) {
		ArrayList<BitInteger> array = new ArrayList<BitInteger>();
		array.add(new BitInteger(0));
		array.add(new BitInteger(1));
		array.add(new BitInteger(2));
		array.add(new BitInteger(4));
		array.add(new BitInteger(5));
		
		System.out.println(findMissing(array));
	}
}
