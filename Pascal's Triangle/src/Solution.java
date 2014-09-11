import java.util.*;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            if (i > 0) {
                List<Integer> lastRow = list.get(i - 1);
                for (int j = 1; j < i; j++) {
                    row.add(lastRow.get(j) + lastRow.get(j - 1));
                }
                row.add(1);
            }
            list.add(row);
        }
        return list;
    }
}
