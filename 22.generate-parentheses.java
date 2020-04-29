import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (60.71%)
 * Likes:    4547
 * Dislikes: 245
 * Total Accepted:    505.7K
 * Total Submissions: 831.3K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */

// @lc code=start
class Solution {
    /**
     * 回溯
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recur(0, 0, n, "", result);
        return result;
    }

    private void recur(int left, int right, int n, String temp, List<String> result) {
        if (left == n && right == n) {
            result.add(temp);
            return;
        }
        if (left < n) {
            recur(++left, right, n, temp + '(', result);
        }
        if (right < left) {
            recur(left, ++right, n, temp + ')', result);
        }
    }
}
// @lc code=end

