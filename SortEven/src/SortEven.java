
public class SortEven {
	public static void sort(int[] array) {
		if (array.length <= 1) {
			return;
		}
		
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if ((array[i] & 1) == 1) {
				int tmp = array[i];
				array[i] = array[k];
				array[k] = tmp;
				k++;
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void  main(String[] args) {
		int[] array = {1};
		int[] array1 = {1, 2, 3, 4, 5, 6};
		int[] array2 = {2, 4, 6};
		int[] array3 = {1, 3, 5, 7};
		
		SortEven.sort(array);
		SortEven.sort(array1);
		SortEven.sort(array2);
		SortEven.sort(array3);
	}
}
