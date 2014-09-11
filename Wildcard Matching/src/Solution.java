import java.util.ArrayList;
import java.util.HashSet;

/**
 * '?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
 * @author lihaosky
 *
 */

class State {
	public ArrayList<Character> transit = new ArrayList<Character>();
	public int id;
	
	public State(int id) {
		this.id = id;
	}
	
	public void addTransit(char t) {
		transit.add(t);
	}
}

public class Solution {
	public boolean isMatch1(String s, String p) {
		if (s.length() == 0 && p.length() == 0) {
			return true;
		}
		if (p.length() == 0) {
			return false;
		}
		State[] fsm = constructFSM(p);
		HashSet<State> states = new HashSet<State>();
		states.add(fsm[0]);
		for (int i = 0; i < s.length(); i++) {
			HashSet<State> newStates = new HashSet<State>();
			for (State state : states) {
				for (char c : state.transit) {
					if (s.charAt(i) == c || c == '?') {
						newStates.add(fsm[state.id + 1]);
					}
					if (c == '*') {
						newStates.add(state);
					}
				}
			}
			states = newStates;
			if (states.size() == 0) {
				return false;
			}
		}
		for (State state : states) {
			if (state.id == fsm.length - 1) {
				return true;
			}
		}
		return false;
	}
	
	public static State[] constructFSM(String p) {
		ArrayList<State> states = new ArrayList<State>();
		int index = 0;
		State state = new State(index++);
		state.addTransit(p.charAt(0));
		states.add(state);
		for (int i = 1; i < p.length(); i++) {
			if (p.charAt(i) != '*') {
				if (p.charAt(i - 1) != '*') {
					state = new State(index++);
					state.addTransit(p.charAt(i));
					states.add(state);
				} else {
					state.addTransit(p.charAt(i));
				}
			} else {
				if (p.charAt(i - 1) != '*') {
					state = new State(index++);
					state.addTransit(p.charAt(i));
					states.add(state);
				}
			}
		}
		if (p.charAt(p.length() - 1) != '*') {
			states.add(new State(index++));
		}
		State[] res = new State[states.size()];
		states.toArray(res);
		return res;
	}
	
	public static void printFSM(State[] states) {
		for (State s : states) {
			System.out.println("id: " + s.id);
			System.out.print("Transits: ");
			for (char c : s.transit) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
	
	
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (p.length() == 0) {
            return false;
        }
        if (p.charAt(p.length() - 1) != '*' && p.charAt(p.length() - 1) != '?') {
        	if (s.length() == 0) {
        		return false;
        	}
        	if (s.charAt(s.length() - 1) != p.charAt(p.length() - 1)) {
        		return false;
        	}
        }
        if (p.charAt(0) == '*') {
            for (int i = 0; i <= s.length(); i++) {
                if (isMatch(s.substring(i), p.substring(1))) {
                    return true;
                }
            }
            return false;
        }
        if (s.length() == 0) {
            return false;
        }
        if (p.charAt(0) != '?' && p.charAt(0) != s.charAt(0)) {
            return false;
        }
        return isMatch(s.substring(1), p.substring(1));
    }
    
    public boolean isMatch3(String s, String p) {
    	int preSIndex = 0, i = 0, j = 0, start = -1;
    	while (i < s.length()) {
    		if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
    			i++;
    			j++;
    		} else if (j < p.length() && p.charAt(j) == '*') {
    			start = j;
    			preSIndex = i;
    			j++;
    		} else if (start != -1) {
    			i = preSIndex++;
    			j = start + 1;
    		} else {
    			return false;
    		}
    	}
    	for (; j < p.length(); j++) {
    		if (p.charAt(j) != '*') {
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	Solution.printFSM(Solution.constructFSM("****"));
    	System.out.println(new Solution().isMatch1("bbbaaabaababbabbbaabababbbabababaabbaababbbabbbabb", "*b*b*baba*aaa*b*"));
    	//System.out.println(new Solution().isMatch("bbbaaabaababbabbbaabababbbabababaabbaababbbabbbabb", "*b*b*baba*aaa*b*"));
    	System.out.println(new Solution().isMatch1("aaaaa", "aaaa"));
    	System.out.println(new Solution().isMatch1("bbbaaabaababbabbbaabababbbabababaabbaababbbabbbabb", "*b*b*baba*aaa*b*"));
    	
    	System.out.println(new Solution().isMatch3("bbbaaabaababbabbbaabababbbabababaabbaababbbabbbabb", "*b*b*baba*aaa*b*"));
    	//System.out.println(new Solution().isMatch("bbbaaabaababbabbbaabababbbabababaabbaababbbabbbabb", "*b*b*baba*aaa*b*"));
    	System.out.println(new Solution().isMatch3("b", "*a*"));
    	System.out.println(new Solution().isMatch3("bbbaaabaababbabbbaabababbbabababaabbaababbbabbbabb", "*b*b*baba*aaa*b*"));
    }
}
