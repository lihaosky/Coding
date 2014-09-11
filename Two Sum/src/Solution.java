import java.util.*;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> positionMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            positionMap.put(numbers[i], i + 1);
        }
        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            if (positionMap.containsKey(diff) && positionMap.get(diff) != i + 1) {
                res[0] = i + 1;
                res[1] = positionMap.get(diff);
                break;
            }
        }
        return res;
    }
}