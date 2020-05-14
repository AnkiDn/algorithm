#
# @lc app=leetcode id=22 lang=python3
#
# [22] Generate Parentheses
#
# https://leetcode.com/problems/generate-parentheses/description/
#
# algorithms
# Medium (60.71%)
# Likes:    4547
# Dislikes: 245
# Total Accepted:    505.7K
# Total Submissions: 831.3K
# Testcase Example:  '3'
#
# 
# Given n pairs of parentheses, write a function to generate all combinations
# of well-formed parentheses.
# 
# 
# 
# For example, given n = 3, a solution set is:
# 
# 
# [
# ⁠ "((()))",
# ⁠ "(()())",
# ⁠ "(())()",
# ⁠ "()(())",
# ⁠ "()()()"
# ]
# 
#

# @lc code=start
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        def dfs(temp, left, right):
            if len(temp) == 2 * n:
                ans.append(''.join(temp))
                return
            if left < n:
                dfs(temp + '(', left + 1, right)
            if right < left:
                dfs(temp + ')', left, right + 1)
        dfs("", 0 , 0)
        return ans

        
# @lc code=end

