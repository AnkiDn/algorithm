/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (42.28%)
 * Likes:    4395
 * Dislikes: 103
 * Total Accepted:    360.1K
 * Total Submissions: 851.8K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * Example:
 * 
 * 
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore
 * the length is 4. 
 * 
 * Note: 
 * 
 * 
 * There may be more than one LIS combination, it is only necessary for you to
 * return the length.
 * Your algorithm should run in O(n^2) complexity.
 * 
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 */

// @lc code=start
class Solution {
    /**
     * 贪心+dp+二分
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length, i = 0;
        if (len < 2) return len;
        // dp 数组的定义：在长度为 i + 1 的上升子序列中的选择末尾数最小的那一个
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int num : nums) {
            //比 dp 数组实际有效的末尾的那个元素还大,直接添加在那个元素的后面,所以 i 先加 1
            if (num > dp[i]) dp[++i] = num;
            // 使用二分查找法，在有序数组 dp 中,找到第 1 个大于等于 nums[i] 的元素
            // 然后替换变成更小的
            else binarySearchAndReplace(dp, 0, i, num);
        }
        return i + 1;
    }

    private void binarySearchAndReplace(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target) right = mid;
            else left = mid + 1;
        }
        //这里num已经小于dp[i]了所以不可能溢出, 并且num>=dp[l]所以满足条件
        nums[left] = target;
    }

    /**
     * dp
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        int ans = 0, n = nums.length;
        if (n == 0) return ans;
        // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度。
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
// @lc code=end

