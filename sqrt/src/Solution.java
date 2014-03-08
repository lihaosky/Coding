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
    public static void main(String[] args) {
    	new Solution().sqrt(2147483647);
    }
}
