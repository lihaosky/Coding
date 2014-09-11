public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sol = 0, partialSum = 0, sum = 0;
        for (int i = 0; i < gas.length; i++) {
            partialSum += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (partialSum < 0) {
                sol = i;
                partialSum = 0;
            }
        }
        if (sum < 0) {
            return -1;
        }
        return sol + 1;
    }
}