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
    		for (int state : states) {
    			ArrayList<Transition> transitions = transitionMap.get(state);
    			for (Transition t : transitions) {
    				if (t.transit.equals("wild") || t.transit.equals("empty") || t.transit.equals(s.charAt(i) + "")) {
    					tmpStates.add(t.nextState);
    				} 
    			}
    		}
    		states = tmpStates;
    		i++;
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
    
	public static void main(String[] args) {
		System.out.println(new Solution().isMatch("aaa", "c*a*aaa"));
	}
}
