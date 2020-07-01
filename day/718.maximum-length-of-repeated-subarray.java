/*
 * @lc app=leetcode id=718 lang=java
 *
 * [718] Maximum Length of Repeated Subarray
 */

// @lc code=start
class Solution {
    //dp
    public int findLength(int[] a, int[] b) {
        int[][] dp = new int[a.length + 1][b.length + 1];
        int ans = 0;
        for (int i = 1; i <= a.length; ++i) {
            for (int j = 1; j <= b.length; ++j) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                ans = Math.max(dp[i][j], ans);
            }
        }
        return ans;
    }

    //dp优化
    public int findLength(int[] a, int[] b) {
        int[] dp = new int[b.length + 1];
        int ans = 0;
        for (int i = 1; i <= a.length; ++i) {
            for (int j = b.length; j >= 1; --j) {
                if (a[i - 1] == b[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }
                ans = Math.max(dp[j], ans);
            }
        }
        return ans;
    }
}
// @lc code=end

