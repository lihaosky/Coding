import java.util.*;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        generateIp(s, "", 0, result);
        print(result);
        return result;
    }
    
    public void generateIp(String remain, String generated, int level, List<String> result) {
    	if (level == 3) {
    		if (isValidIp(remain)) {
    			result.add(generated + remain);
    		} 
    		return;
    	}
    	for (int i = 1; i <= 3; i++) {
    		if (remain.length() < i) {
    			return;
    		}
    		if (remain.length() - i > 3 * (3 - level)) {
    			continue;
    		}
    		if (isValidIp(remain.substring(0, i))) {
    			generateIp(remain.substring(i), generated + remain.substring(0, i) + ".", level + 1, result);
    		}
    	}
    }
    
    public boolean isValidIp(String num) {
    	if (num == null || num.length() == 0 || num.length() > 3) {
    		return false;
    	}
    	int numeral = Integer.parseInt(num);
    	if (num.charAt(0) == '0' && num.length() != 1) {
    		return false;
    	}
    	if (numeral > 255 || numeral < 0) {
    		return false;
    	}
    	return true;
    }
    
    public void print(List<String> list) {
    	for (String s : list) {
    		System.out.println(s);
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	new Solution().restoreIpAddresses("25525511135");
    	new Solution().restoreIpAddresses("2552551113");
    	new Solution().restoreIpAddresses("2552");
    	new Solution().restoreIpAddresses("255255111235");
    	new Solution().restoreIpAddresses("0000");
    	new Solution().restoreIpAddresses("10001025");
    }
}
