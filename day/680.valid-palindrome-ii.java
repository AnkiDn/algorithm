/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 *
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 *
 * algorithms
 * Easy (36.02%)
 * Likes:    1436
 * Dislikes: 94
 * Total Accepted:    151.3K
 * Total Submissions: 418K
 * Testcase Example:  '"aba"'
 *
 * 
 * Given a non-empty string s, you may delete at most one character.  Judge
 * whether you can make it a palindrome.
 * 
 * 
 * Example 1:
 * 
 * Input: "aba"
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * 
 * 
 * 
 * Note:
 * 
 * The string will only contain lowercase characters a-z.
 * The maximum length of the string is 50000.
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        return valid(s, 0 , s.length() - 1, false);
    }

    public boolean valid(String s, int left, int right, boolean isDeep) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isDeep) return false;
                return valid(s, left + 1, right, true) || valid(s, left, right - 1, true);
            }
            ++left;
            --right;
        }
        return true;
    }

    public boolean validPalindrome2(String s) {
        if (s == null || s.length() == 0) return true;
        int n = s.length();
        int dif = 0;
        int left = 0;
        int right = s.length() - 1;
        for (int i = left, j = right; i < j;) {
            if (s.charAt(i) != s.charAt(j)) {
                return valid_palindrome(s, i + 1, j) || valid_palindrome(s, i , j - 1);
            }
            ++i;
            --j;
        }
        return true;
    }

    public boolean valid_palindrome2(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
// @lc code=end

