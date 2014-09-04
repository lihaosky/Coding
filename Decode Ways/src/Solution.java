public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {
        	return 0;
        }
        if (s.charAt(0) == '0') {
        	return 0;
        }
        if (s.length() < 2) {
        	return 1;
        }
        int prev = 1, cur = 1;
        for (int i = 1; i < s.length(); i++) {
        	if (s.charAt(i) == '0') {
        		if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
        			return 0;
        		} else {
        			cur = prev;
        		}
        		continue;
        	}
        	if (s.charAt(i) > '6') {
        		if (s.charAt(i - 1) == '1') {
        			int tmp = cur;
        			cur += prev;
        			prev = tmp;
        		} else {
        			prev = cur;
        		}
        	} else {
        		if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
        			int tmp = cur;
        			cur += prev;
        			prev = tmp;
        		} else {
        			prev = cur;
        		}
        	}
        }
        return cur;
    }
    
    public static void main(String[] args) {
    	System.out.println(new Solution().numDecodings("1234526"));
    	System.out.println(new Solution().numDecodings("20"));
    	System.out.println(new Solution().numDecodings("12"));
    	System.out.println(new Solution().numDecodings("120"));
    	System.out.println(new Solution().numDecodings("27"));
    }
}
