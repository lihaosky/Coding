import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]. 
 * @author hali3
 *
 */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        if (intervals.size() <= 0) {
        	return res;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval arg0, Interval arg1) {
				return arg0.start - arg1.start;
			}
        	
        });
        Interval interval = new Interval();
        interval.start = intervals.get(0).start;
        interval.end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
        	if (interval.end >= intervals.get(i).start) {
        		interval.end = Math.max(intervals.get(i).end, interval.end);
        	} else {
        		res.add(interval);
        		interval = new Interval(intervals.get(i).start, intervals.get(i).end);
        	}
        }
        res.add(interval);
        return res;
    }
    
    public static void main(String[] args) {
    	ArrayList<Interval> intervals = new ArrayList<Interval>();
    	intervals.add(new Interval(1, 3));
    	intervals.add(new Interval(2, 6));
    	intervals.add(new Interval(8, 10));
    	intervals.add(new Interval(0, 100));
    	ArrayList<Interval> res = new Solution().merge(intervals);
    	for (Interval i : res) {
    		System.out.println(i.start + " " + i.end);
    	}
    }
}
