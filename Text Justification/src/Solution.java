import java.util.ArrayList;

/**
 *  Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:

[
   "This    is    an",
   "example  of text",
   "justification.  "
]

 * @author hali3
 *
 */
public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> text = new ArrayList<String>();
        int index = 0;
        
        while (index < words.length) {
        	ArrayList<String> line = new ArrayList<String>();
        	int lineLen = 0;
        	while (index < words.length) {
        		lineLen += words[index].length();
        		if (lineLen + line.size()> L) {
        			lineLen -= words[index].length();
        			break;
        		}
        		line.add(words[index]);
        		index++;
        	}
        	StringBuilder sb = new StringBuilder();
        	if (index == words.length) {
        		if (line.size() == 1) {
        			sb.append(line.get(0));
        			for (int i = 0; i < L - line.get(0).length(); i++) {
        				sb.append(" ");
        			}
        		} else {
	        		for (int i = 0; i < line.size() - 1; i++) {
	        			sb.append(line.get(i));
	        			sb.append(" ");
	        		}
	        		sb.append(line.get(line.size() - 1));
	        		for (int i = 0; i < L - lineLen - line.size() + 1; i++) {
	        		    sb.append(" ");
	        		}
        		}
        	} else {
        		int emptySpace = L - lineLen;
        		int wordNum = line.size();
        		if (wordNum == 1) {
        			sb.append(line.get(0));
        			for (int i = 0; i < emptySpace; i++) {
        				sb.append(" ");
        			}
        		} else {
	        		int spaceBetween = emptySpace / (wordNum - 1);
	        		int extraSpace = emptySpace % (wordNum - 1);
	        		for (int i = 0; i < wordNum - 1; i++) {
	        			sb.append(line.get(i));
	        			for (int j = 0; j < spaceBetween; j++) {
	        				sb.append(" ");
	        			}
	        			if (extraSpace > 0) {
	        				sb.append(" ");
	        				extraSpace--;
	        			}
	        		}
	        		sb.append(line.get(wordNum - 1));
        		}
        	}
        	text.add(sb.toString());
        }
        return text;
    }
    
    public static void main(String[] args) {
    	String[] s = {""};
    	for (String line : new Solution().fullJustify(s, 16)) {
    		System.out.println(line);
    	}
    }
}
