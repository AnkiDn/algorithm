/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 *
 * https://leetcode.com/problems/house-robber-ii/description/
 *
 * algorithms
 * Medium (36.18%)
 * Likes:    1635
 * Dislikes: 47
 * Total Accepted:    166.8K
 * Total Submissions: 460.6K
 * Testcase Example:  '[2,3,2]'
 *
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last
 * one. Meanwhile, adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were broken into on
 * the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money
 * = 2),
 * because they are adjacent houses.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money =
 * 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        return Math.max(robHouse(nums, 0, n - 2), robHouse(nums, 1, n - 1));
    }

    private int robHouse(int[] nums, int start, int end) {
        int[] dp = new int[nums.length + 1];
        dp[start + 1] = nums[start];
        // dp[start + 1] = Math.max(dp[start], nums[start + 1]);
        for (int i = start + 2; i <= end + 1; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[end + 1];
    }

    private int robHouse2(int[] nums, int start, int end) {
        int[] dp = new int[3];
        for (int i = start; i <= end; ++i) {
            dp[2] = Math.max(dp[1], dp[0] + nums[i]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }
}
}
// @lc code=end

