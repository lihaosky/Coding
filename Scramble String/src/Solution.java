public class Solution {
    public boolean isScramble(String s1, String s2) {
    	if (s1 == null && s2 == null) {
    		return true;
    	}
    	if (s1 == null || s2 == null) {
    		return false;
    	}
    	if (s1.length() != s2.length()) {
    		return false;
    	}
        if (s1.equals(s2) || new StringBuilder(s1).reverse().toString().equals(s2)) {
        	return true;
        }
        int[] s1Count = new int[300];
        int[] s2Count = new int[300];
        for (int i = 0; i < s1.length(); i++) {
        	s1Count[s1.charAt(i)]++;
        	s2Count[s2.charAt(i)]++;
        }
        for (int i = 0; i < 300; i++) {
        	if (s1Count[i] != s2Count[i]) {
        		return false;
        	}
        }
        for (int i = 1; i < s1.length(); i++) {
        	String s1Left = s1.substring(0, i);
        	String s1Right = s1.substring(i, s1.length());
        	String s2Left = s2.substring(0, i);
        	String s2Right = s2.substring(i, s2.length());
        	if (isScramble(s1Left, s2Left) && isScramble(s1Right, s2Right)) {
        		return true;
        	}
        	s2Left = s2.substring(0, s2.length() - i);
        	s2Right = s2.substring(s2.length() - i, s2.length());
        	if (isScramble(s1Left, s2Right) && isScramble(s1Right, s2Left)) {
        		return true;
        	}
        }
        return false;
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().isScramble("great", "rgeat"));
    	System.out.println(new Solution().isScramble("great", "abcde"));
    	System.out.println(new Solution().isScramble("a", "a"));
    	System.out.println(new Solution().isScramble("abcd", "dcba"));
    	System.out.println(new Solution().isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));
    }
}
