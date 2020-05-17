#
# @lc app=leetcode id=78 lang=python3
#
# [78] Subsets
#
# https://leetcode.com/problems/subsets/description/
#
# algorithms
# Medium (58.91%)
# Likes:    3208
# Dislikes: 75
# Total Accepted:    520K
# Total Submissions: 879K
# Testcase Example:  '[1,2,3]'
#
# Given a set of distinct integers, nums, return all possible subsets (the
# power set).
# 
# Note: The solution set must not contain duplicate subsets.
# 
# Example:
# 
# 
# Input: nums = [1,2,3]
# Output:
# [
# ⁠ [3],
# [1],
# [2],
# [1,2,3],
# [1,3],
# [2,3],
# [1,2],
# []
# ]
# 
#

# @lc code=start
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = []
        if not nums: return ans
        self.dfs(ans, 1, nums, [])
        return ans
    
    def dfs(self, ans, level, nums, temp):
        if level == len(nums):
            ans.append(temp.copy())
            return
        for i in range(len(nums)):
            if nums[i] in temp: continue
            self.dfs(ans, level + 1, nums, temp)
            temp.append(nums[i])
            self.dfs(ans, level + 1, nums, temp)
# @lc code=end

