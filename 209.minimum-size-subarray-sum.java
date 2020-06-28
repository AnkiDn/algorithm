/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    //滑动窗口
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length, sum = 0, ans = len + 1;
        int i = 0, j = 0;
        while (i < len) {
            sum += nums[i];
            while (j <= i && sum >= s) {
                ans = Math.min(ans, i - j + 1);
                sum -= nums[j];
                j++;
            }
            i++;
        }
        return ans == len + 1 ? 0 : ans;
    }

    /**
     * 前缀和+二分
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length, ans = len + 1;
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; ++i) sum[i] = sum[i - 1] + nums[i - 1];
        for (int i = 1; i <= len; ++i) {
            int targe = s + sum[i - 1];
            int bound = Arrays.binarySearch(sum, targe);
            if (bound < 0) bound = -bound - 1;
            if (bound <= len) {
                ans = Math.min(ans, bound - i + 1);
            }
        }
        return ans == len + 1 ? 0 : ans;
    }
}
// @lc code=end

