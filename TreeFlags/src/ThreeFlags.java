
public class ThreeFlags {
	public static void sortFlag(int[] a) {
		int p = 0;
		int q = 0;
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				int num = a[i];
				a[i] = a[q];
				a[q] = a[p];
				a[p] = num;
				p++;
				q++;
			} else if (a[i] == 1) {
				int num = a[i];
				a[i] = a[q];
				a[q] = num;
				q++;
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] a = {0, 1, 2};
		ThreeFlags.sortFlag(a);
	}
}
