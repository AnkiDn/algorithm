/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (23.92%)
 * Likes:    2401
 * Dislikes: 2615
 * Total Accepted:    375.5K
 * Total Submissions: 1.6M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */

// @lc code=start
class Solution {
    /**
     * dp[i]数组是对于长度为i当字符串所能解码的方法总数
        `dp[i] = dp[i - 1] + dp[i - 2];`
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < n; ++i) {
            int first = s.charAt(i) - '0';
            int second = (s.charAt(i - 1) - '0') * 10 + first;
            if (first > 0 && first < 10) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += i >= 2 ? dp[i - 2] : 1;
            }
        }
        return dp[n - 1];
    }
}
// @lc code=end

