#
# @lc app=leetcode id=47 lang=python3
#
# [47] Permutations II
#
# https://leetcode.com/problems/permutations-ii/description/
#
# algorithms
# Medium (44.88%)
# Likes:    1695
# Dislikes: 58
# Total Accepted:    328.6K
# Total Submissions: 730.4K
# Testcase Example:  '[1,1,2]'
#
# Given a collection of numbers that might contain duplicates, return all
# possible unique permutations.
# 
# Example:
# 
# 
# Input: [1,1,2]
# Output:
# [
# ⁠ [1,1,2],
# ⁠ [1,2,1],
# ⁠ [2,1,1]
# ]
# 
# 
#

# @lc code=start
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        ans = []
        if not nums:
            return ans
        nums.sort()
        used = [False] * len(nums)
        self.dfs(nums, [], used, ans)
        return ans
    
    def dfs(self, nums, path, used, ans):
        if len(path) == len(nums):
            ans.append(path.copy())
            return
        for i, value in enumerate(nums):
            if used[i]: continue
            if i > 0 and nums[i] == nums[i - 1] and not used[i - 1]:
                continue
            used[i] = True
            path.append(value)
            self.dfs(nums, path, used, ans)
            used[i] = False
            path.pop()
# @lc code=end

