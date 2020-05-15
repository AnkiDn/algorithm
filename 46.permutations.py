#
# @lc app=leetcode id=46 lang=python3
#
# [46] Permutations
#
# https://leetcode.com/problems/permutations/description/
#
# algorithms
# Medium (61.33%)
# Likes:    3400
# Dislikes: 98
# Total Accepted:    556.1K
# Total Submissions: 904.1K
# Testcase Example:  '[1,2,3]'
#
# Given a collection of distinct integers, return all possible permutations.
# 
# Example:
# 
# 
# Input: [1,2,3]
# Output:
# [
# ⁠ [1,2,3],
# ⁠ [1,3,2],
# ⁠ [2,1,3],
# ⁠ [2,3,1],
# ⁠ [3,1,2],
# ⁠ [3,2,1]
# ]
# 
# 
#

# @lc code=start
class Solution:
    def __init__(self):
        self.ans = []
    def permute(self, nums: List[int]) -> List[List[int]]:
        if not nums: return self.ans
        self.dfs([], nums)
        return self.ans

    def dfs(self, temp, nums):
        if (len(temp) == len(nums)):
            self.ans.append(temp[:])
            return
        for i in nums:
            if i in temp: continue
            temp.append(i)
            self.dfs(temp, nums)
            temp.pop()
        
        
# @lc code=end

