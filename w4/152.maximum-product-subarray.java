/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (31.06%)
 * Likes:    3664
 * Dislikes: 148
 * Total Accepted:    314.6K
 * Total Submissions: 1M
 * Testcase Example:  '[2,3,-2,4]'
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < 0) {
                max ^= min;
                min ^= max;
                max ^= min;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }

    public int maxProduct2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = nums[0];
        int[][] dp = new int[nums.length][2];
        dp[0][0] = dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > 0) {
                dp[i][0] = Math.max(nums[i], dp[i - 1][0] * nums[i]);
                dp[i][1] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
            } else {
                dp[i][0] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
                dp[i][1] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
            }
            ans = Math.max(ans, dp[i][0]);
        }
        return ans;
    }
}
// @lc code=end

