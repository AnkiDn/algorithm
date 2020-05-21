/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (28.99%)
 * Likes:    6341
 * Dislikes: 507
 * Total Accepted:    893.2K
 * Total Submissions: 3.1M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * dp
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {
        int n = s.length();
        if (n < 2) return s;
        int begin = 0;
        int length = 1;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
        }
        for (int j = 1; j < n; ++j) {
            for (int i = 0; i < j; ++i) {
                if (s.charAt(j) != s.charAt(i)) continue;
                if (j - i + 1 <= 3) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && (j - i + 1) > length) {
                    begin = i;
                    length = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + length);
    }

    /**
     * 暴力
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int n = s.length();
        if (n <= 1) return s;
        int[] ans = new int[3];
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int max = i - j + 1;
                if (max > ans[0] && valid_palindromic(s, j, i)) {
                    if (max > ans[0]) {
                        ans[0] = max;
                        ans[1] = j;
                        ans[2] = i;
                    }
                }
            }
        }
        String str = s.substring(ans[1], ans[2] + 1);
        return str;
    }

    public boolean valid_palindromic(String s, int left, int right) {
        while(left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }


    /**
     * 中心扩散
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;
        String ansStr = "";
        for (int i = 0; i < n - 1; ++i) {
            String singleStr = spreadFromIndex(s, i, i);
            String doubleStr = spreadFromIndex(s, i, i + 1);
            String maxLengthStr = singleStr.length() > doubleStr.length() ? singleStr : doubleStr;
            if (maxLengthStr.length() > ansStr.length()) {
                ansStr = maxLengthStr;
            }
        }
        return ansStr;
    }

    public String spreadFromIndex(String s, int left, int right) {
        while(left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) break;
            --left;
            ++right;
        }
        return s.substring(left + 1, right);
    }
}
// @lc code=end

