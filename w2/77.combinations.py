#
# @lc app=leetcode id=77 lang=python3
#
# [77] Combinations
#
# https://leetcode.com/problems/combinations/description/
#
# algorithms
# Medium (52.87%)
# Likes:    1279
# Dislikes: 63
# Total Accepted:    271K
# Total Submissions: 511.3K
# Testcase Example:  '4\n2'
#
# Given two integers n and k, return all possible combinations of k numbers out
# of 1 ... n.
# 
# Example:
# 
# 
# Input: n = 4, k = 2
# Output:
# [
# ⁠ [2,4],
# ⁠ [3,4],
# ⁠ [2,3],
# ⁠ [1,2],
# ⁠ [1,3],
# ⁠ [1,4],
# ]
# 
# 
#

# @lc code=start
class Solution:
    def __init__(self):
        self.ans = []
    def combine(self, n: int, k: int) -> List[List[int]]:
        def dfs(start, n, k, temp):
            if not k: 
                self.ans.append(temp[:])
                return
            for i in range(start + 1, n + 1):
                if i not in temp:
                    temp.append(i)
                    dfs(i, n, k - 1, temp)
                    temp.pop()
        dfs(0, n, k, [])
        return self.ans

# @lc code=end

