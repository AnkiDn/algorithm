/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int len_s = s.length(), len_p = p.length();
        char[] cs = s.toCharArray(), cp = p.toCharArray();
        boolean[][] dp = new boolean[len_s + 1][len_p + 1];
        dp[0][0] = true;
        for (int j = 1; j <= len_p; ++j) {
            if (cp[j - 1] == '*') dp[0][j] = dp[0][j - 1];
        }
        for (int i = 1; i <= len_s; ++i) {
            for (int j = 1; j <= len_p; ++j) {
                if (cs[i - 1] == cp[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]; 
                } else if (cp[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (cp[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[len_s][len_p];
    }
}
// @lc code=end

