/**
 * 
 * @author lihaosky
 *
 */
public class Solution {
    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        double epslon = 0.00001;
        double res = x / 2.0 + 0.5;
        while (res * res - x > epslon) {
            res = (res + x / res) / 2;
        }
        return (int)res;
    }
    
    public int sqrt1(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int l = 1, r = x;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            System.out.println("Mid is " + mid);
            int qut = x / mid;
            if (qut == mid) {
                return mid;
            } else if (qut < mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().sqrt(2147483647));
    	int a = 2147483647 / 2;
    	System.out.println(a * a);
    	System.out.println(new Solution().sqrt1(2147483647));
    	String[] path = "/home/abcd".split("/");
    	System.out.println(path[2]);
    }
}
