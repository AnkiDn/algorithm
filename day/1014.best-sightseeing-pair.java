/*
 * @lc app=leetcode id=1014 lang=java
 *
 * [1014] Best Sightseeing Pair
 */

// @lc code=start
class Solution {
    // A[i] + A[j] + i - j 可以变换为 (A[i] + i) + (A[j] - j)
    // max = A[i] + i
    // 因为A[i] + i 在 j 前面就确定了，所以对于j点的最高得分就为：
    // ans = Math.max(ans, max + a[j] - j)
    public int maxScoreSightseeingPair(int[] a) {
        int ans = 0, len = a.length;
        int max = a[0];
        for (int i = 1; i < len; ++i) {
            ans = Math.max(ans, max + a[i] - i);
            max = Math.max(max, a[i] + i);
        }
        return ans;
    }
}
// @lc code=end

