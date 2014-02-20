/**
 *  There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give? 
 * @author hali3
 *
 */
public class Solution {
    public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		if (ratings.length == 1) {
			return 1;
		}

		int[] candies = new int[ratings.length];
		int sum = 0;
		for (int i = 0; i < candies.length; i++) {
		    candies[i] = 1;
		}
		for (int i = 1; i < candies.length; i++) {
		    if (ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
		        candies[i] = candies[i - 1] + 1;
		    }
		}
		for (int i = candies.length - 2; i >= 0; i--) {
		    if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
		        candies[i] = candies[i + 1] + 1;
		    }
		}
		for (int i = 0; i < candies.length; i++) {
		    sum += candies[i];
		}
		return sum;
    }
}
