/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area. 
 */
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		char[][] matrix = generateMatrix(120, 120);
		//printMatrix(matrix);
		long startTime = System.currentTimeMillis();
		int maxArea = new Solution().maximalRectangle(matrix);
		long endTime = System.currentTimeMillis();
		System.out.println("Total execution time for merge: " + (endTime - startTime) );
		startTime = System.currentTimeMillis();
		int maxBrutalArea = new Solution().maxBrutal(matrix);
		endTime = System.currentTimeMillis();
		System.out.println("Total execution time for brutal: " + (endTime - startTime) );
		System.out.println(maxArea + " " + maxBrutalArea);
	}
	
	public static void printMatrix(char[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static char[][] generateMatrix(int length, int width) {
		char[][] matrix = new char[length][width];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				Random rand = new Random();
				if (rand.nextInt(4) == 0) {
					matrix[i][j] = '0';
				} else {
					matrix[i][j] = '1';
				}
			}
		}
		return matrix;
	}
	
	public void printAreaList(ArrayList<Area> areaList) {
		for (Area area : areaList) {
			System.out.println("Start: " + area.start + ", end: " + area.end + ", len: " + area.len);
		}
	}
	
	public ArrayList<Area> mergeArea(ArrayList<Area> newAreaList, ArrayList<Area> areaList) {
		ArrayList<Area> mergedAreaList = new ArrayList<Area>();
		for (Area area : newAreaList) {
			boolean isPerfect = false;
			for (Area area1 : areaList) {
				// Perfect match
				if (area.start == area1.start && area.end == area1.end) {
					isPerfect = true;
					mergedAreaList.add(new Area(area.start, area.end, area1.len + 1));
					break;
				}
				// New area contains previous one
				else if (area.start <= area1.start && area.end >= area1.end) {
					mergedAreaList.add(new Area(area1.start, area1.end, area1.len + 1));
				}
				// New area contained by previous one
				else if (area.start >= area1.start && area.end <= area1.end) {
					mergedAreaList.add(new Area(area.start, area.end, area1.len + 1));
					isPerfect = true;
					break;
				}
				else if (area.start < area1.start && area.end >= area1.start && area.end <= area1.end) {
					mergedAreaList.add(new Area(area1.start, area.end, area1.len + 1));
				}
				else if (area.start >= area1.start && area.start <= area1.end && area.end > area1.end) {
					mergedAreaList.add(new Area(area.start, area1.end, area1.len + 1));
				}
			}
			if (isPerfect) {
				continue;
			}
			mergedAreaList.add(new Area(area.start, area.end, 1));
		}
		
		return mergedAreaList;
	}
	
	public boolean isAll1(char[][] matrix, int i, int j, int m, int n) {
		for (int starti = i; starti <= m; starti++) {
			for (int startj = j; startj <= n; startj++) {
				if (matrix[starti][startj] == '0') {
					return false;
				}
			}
		}
		return true;
	}
	
	public int maxBrutal(char[][] matrix) {
		if (matrix.length <= 0) {
			return 0;
		}
		int maxArea = 0;
		for (int starti = 0; starti < matrix.length; starti++) {
			for (int startj = 0; startj < matrix[0].length; startj++) {
				for (int endi = starti; endi < matrix.length; endi++) {
					for (int endj = startj; endj < matrix[0].length; endj++) {
						if (isAll1(matrix, starti, startj, endi, endj)) {
							if ((endi - starti + 1) * (endj - startj + 1) > maxArea) {
								maxArea = (endi - starti + 1) * (endj - startj + 1);
							}
						}
					}
				}
			}
		}
		return maxArea;
	}
	
    public int maximalRectangle(char[][] matrix) {
    	ArrayList<Area> areaList = new ArrayList<Area>();
    	if (matrix.length <= 0) {
    		return 0;
    	}
    	int maxArea = 0;
    	for (int i = 0; i < matrix[0].length; i++) {
    		ArrayList<Area> newAreaList = new ArrayList<Area>();
    		for (int j = 0; j < matrix.length; j++) {
    			if (matrix[j][i] == '0') {
    				continue;
    			}
    			int end = j + 1;
    			while (end < matrix.length && matrix[end][i] == '1') {
    				end++;
    			}
    			end--;
    			newAreaList.add(new Area(j, end, 1));
    			j = end;
    		}
    		areaList = mergeArea(newAreaList, areaList);
    		for (Area area : areaList) {
    			if ((area.end - area.start + 1) * area.len >= maxArea) {
    				maxArea = (area.end - area.start + 1) * area.len;
    			}
    		}
    	}
        return maxArea;
    }
}

class Area {
	public int start;
	public int end;
	public int len;
	
	public Area(int start, int end, int len) {
		this.start = start;
		this.end = end;
		this.len = len;
	}
}
