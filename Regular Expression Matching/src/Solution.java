import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 */
/**
 * Nondeterministic finite automata
 * 
 * And a much simpler solution with recursion...
 * 
 * @author lihaosky
 *
 */

class Transition {
	String transit;
	int nextState;
	int isEnd;
	
	public Transition(String transit, int nextState) {
		this.transit = transit;
		this.nextState = nextState;
	}
	
	public Transition(char transit, int nextState) {
		this.transit = transit + "";
		this.nextState = nextState;
	}
}

public class Solution {
	/**
	 * This method uses recursion to match, much simpler than the NFA method...
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch1(String s, String p) {
		// If s and p are both empty
		if (s.length() == 0 && p.length() == 0) {
			return true;
		}
		// If one of s and p's length is 0
		// S's length is 0 and p's length isn't 0 can still match. e.g. "" and "b*"
		if (p.length() == 0) {
			return false;
		}
		if (p.length() == 1) {
			return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
		}
		if (p.charAt(1) != '*') {
			return s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch1(s.substring(1), p.substring(1));
		}
		int i = 0;
		while (i < s.length() && (p.charAt(0) == '.' || s.charAt(i) == p.charAt(0))) {
			if (isMatch1(s.substring(i + 1), p.substring(2))) {
				return true;
			}
			i++;
		}
		return isMatch1(s, p.substring(2));
	}
	
    public boolean isMatch(String s, String p) {
    	HashSet<Integer> states = new HashSet<Integer>();
    	int i = 0;
    	
    	states.add(0);
    	HashMap<Integer, ArrayList<Transition>> transitionMap = parseReg(p);
    	while (i < s.length()) {
    		HashSet<Integer> tmpStates = new HashSet<Integer>();
    		// Go over all the empty states first
    		while (true) {
    			tmpStates = new HashSet<Integer>();
    			for (int state : states) {
    				tmpStates.add(state);
        			ArrayList<Transition> transitions = transitionMap.get(state);
        			for (Transition t : transitions) {
        				if (t.transit.equals("empty")) {
        					tmpStates.add(t.nextState);
        				} 
        			}
    			}
    			if (tmpStates.size() == states.size()) {
    				break;
    			}
    			states = tmpStates;
    		}
    		
    		tmpStates = new HashSet<Integer>();
    		boolean matched = false;
    		for (int state : states) {
    			ArrayList<Transition> transitions = transitionMap.get(state);
    			for (Transition t : transitions) {
    				if (t.transit.equals("wild") || t.transit.equals(s.charAt(i) + "")) {
    					tmpStates.add(t.nextState);
    					matched = true;
    				}
    			}
    		}
    		if (tmpStates.size() == 0) {
    			return false;
    		}
    		if (matched) {
    			i++;
    		}
    		states = tmpStates;
    	}
    	for (int state : states) {
    		ArrayList<Transition> transitions = transitionMap.get(state);
    		for (Transition t : transitions) {
    			if (t.transit.equals("end")) {
    				return true;
    			}
    		}
    	}
    	
    	while (true) {
    		HashSet<Integer> tmpStates = new HashSet<Integer>();
	    	for (int state : states) {
	    		ArrayList<Transition> transitions = transitionMap.get(state);
	    		for (Transition t : transitions) {
	    			if (t.transit.equals("end")) {
	    				return true;
	    			}
	    			if (t.transit.equals("empty")) {
	    				tmpStates.add(t.nextState);
	    			}
	    		}
	    	}
	    	if (tmpStates.size() == 0) {
	    		break;
	    	}
	    	states = tmpStates;
    	}
    	
        return false;
    }
    
    public HashMap<Integer, ArrayList<Transition>> parseReg(String p) {
    	HashMap<Integer, ArrayList<Transition>> transitionMap = new HashMap<Integer, ArrayList<Transition>>();
    	int i = 0;
    	int state = 0;
    	ArrayList<Transition> transitionList;
    	while (i < p.length()) {
    		transitionList = new ArrayList<Transition>();
    		if (i + 1 < p.length() && p.charAt(i + 1) == '*') {
    			if (p.charAt(i) == '.') {
    				transitionList.add(new Transition("wild", state));
    			} else {
    				transitionList.add(new Transition(p.charAt(i), state));
    			}
    			transitionList.add(new Transition("empty", state + 1));
    			i += 2;
    		} else {
    			if (p.charAt(i) == '.') {
    				transitionList.add(new Transition("wild", state + 1));
    			} else {
    				transitionList.add(new Transition(p.charAt(i), state + 1));
    			}
    			i++;
    		}
    		transitionMap.put(state, transitionList);
    		state++;
    	}
    	transitionList = new ArrayList<Transition>();
    	transitionList.add(new Transition("end", 0));
    	transitionMap.put(state, transitionList);

    	return transitionMap;
    }
    
    public boolean isMatch3(String s, String p) {
    	if (s.length() == 0 && p.length() == 0) {
    		return true;
    	}
    	if (p.length() == 0) {
    		return false;
    	}
    	if (p.length() > 1 && p.charAt(1) == '*') {
    		if (isMatch3(s.substring(0), p.substring(2))) {
    			return true;
    		}
    		for (int i = 1; i <= s.length(); i++) {
    			if (p.charAt(0) != '.' && p.charAt(0) != s.charAt(i - 1)) {
    				break;
    			}
    			if (isMatch3(s.substring(i), p.substring(2))) {
    				return true;
    			}
    		}
    		return false;
    	} else {
    		if (s.length() == 0) {
    			return false;
    		}
    		if (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0)) {
    			return false;
    		}
    		return isMatch3(s.substring(1), p.substring(1));
    	}
    }
    
	public static void main(String[] args) {
/*		System.out.println(new Solution().isMatch("aaa", "c*a*aaa"));
		System.out.println(new Solution().isMatch("aaa", "ab*a"));
		System.out.println(new Solution().isMatch("   ", ".*"));
		System.out.println(new Solution().isMatch1("aaa", "c*a*aaa"));
		System.out.println(new Solution().isMatch1("aaa", "ab*a"));
		System.out.println(new Solution().isMatch1("   ", ".*"));
		System.out.println(new Solution().isMatch3("aaa", "c*a*aaa"));
		System.out.println(new Solution().isMatch3("aaa", "ab*a"));
		System.out.println(new Solution().isMatch3("   ", ".*"));*/
		System.out.println(new Solution().isMatch3("aaa", "c*a*aaa"));
		System.out.println(new Solution().isMatch3("aaa", "ab*a"));
		System.out.println(new Solution().isMatch3("   ", ".*"));
		System.out.println("".substring(0));
	}
}
