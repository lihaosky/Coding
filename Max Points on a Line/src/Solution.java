import java.util.Hashtable;

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
 
public class Solution {
    public int maxPoints(Point[] points) {
    	if (points.length <= 2) {
    		return points.length;
    	}
    	int max_count = 1;
    	for (int i = 0; i < points.length; i++) {
    		Point startPoint = points[i];
    		int duplicate = 0, horizontal = 1, vertical = 1, max = 1;
    		Hashtable<Double, Integer> slopeTable = new Hashtable<Double, Integer>();
    		for (int j = i + 1; j < points.length; j++) {
	    		if (points[j].x == startPoint.x && points[j].y == startPoint.y) {
	    			duplicate++;
	    			continue;
	    		}
	    		if (points[j].x == startPoint.x) {
	    			horizontal++;
	    			if (horizontal > max) {
	    				max = horizontal;
	    			}
	    		} else if (points[j].y == startPoint.y) {
	    			vertical++;
	    			if (vertical > max) {
	    				max = vertical;
	    			}
	    		} else {
	    			double slope = ((double)(points[j].y - startPoint.y)) / (points[j].x - startPoint.x);
	    			Integer count = slopeTable.get(slope);
	    			if (count == null) {
	    				slopeTable.put(slope, 2);
	    				if (max < 2) {
	    					max = 2;
	    				}
	    			} else {
	    				slopeTable.put(slope, count.intValue() + 1);
	    				if (count.intValue() + 1 > max) {
	    					max = count.intValue() + 1;
	    				}
	    			}
	    		}
    		}
    		if (max + duplicate > max_count) {
    			max_count = max + duplicate;
    		}
    	}
    	return max_count;
    }
    
    public static void main(String[] args) {
    	Point[] points = new Point[5];
    	points[0] = new Point(-4, -4);
    	points[1] = new Point(-8, -582);
    	points[2] = new Point(-3, 3);
    	points[3] = new Point(-9, -651);
    	points[4] = new Point(9, 591);
    	System.out.println(new Solution().maxPoints(points));
    }
}