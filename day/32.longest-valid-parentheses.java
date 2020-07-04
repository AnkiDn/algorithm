/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    //栈
    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque(cs.length);
        stack.push(-1);
        for (int i = 0; i < cs.length; ++i) {
            if (cs[i] == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else ans = Math.max(ans, i - stack.peek());
            }
        }
        return ans;
    }

    //不使用额外空间
    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        int left = 0, right = 0, ans = 0;
        for (int i = 0; i < cs.length; ++i) {
            if (cs[i] == '(') left++;
            else right++;
            if (left == right) ans = Math.max(ans, right * 2);
            else if (right > left) left = right = 0;
        }
        left = right = 0;
        for (int i = cs.length - 1; i >= 0; --i) {
            if (cs[i] == '(') left++;
            else right++;
            if (left == right) ans = Math.max(ans, left * 2);
            else if (left > right) left = right = 0;
        }
        return ans;
    }

    //dp
    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        //dp[i]表示以下标为i结尾的合法括号最长长度
        //那么以左括号结尾的字符串一定是非法序列，所以 dp 是零。
        //https://leetcode-cn.com/problems/longest-valid-parentheses/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-7/
        int[] dp = new int[cs.length];
        int ans = 0;
        for (int i = 1; i < cs.length; ++i) {
            if (cs[i] == ')') {
                if (cs[i - 1] == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && cs[i - dp[i - 1] - 1] == '(') {
                    dp[i] = (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
// @lc code=end

