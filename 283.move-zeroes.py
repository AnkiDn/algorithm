#
# @lc app=leetcode id=283 lang=python3
#
# [283] Move Zeroes
#
# https://leetcode.com/problems/move-zeroes/description/
#
# algorithms
# Easy (57.23%)
# Likes:    3395
# Dislikes: 111
# Total Accepted:    757.2K
# Total Submissions: 1.3M
# Testcase Example:  '[0,1,0,3,12]'
#
# Given an array nums, write a function to move all 0's to the end of it while
# maintaining the relative order of the non-zero elements.
# 
# Example:
# 
# 
# Input: [0,1,0,3,12]
# Output: [1,3,12,0,0]
# 
# Note:
# 
# 
# You must do this in-place without making a copy of the array.
# Minimize the total number of operations.
# 
#

# @lc code=start
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        firstZero = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[firstZero], nums[i] = nums[i], nums[firstZero]
                firstZero += 1

            
        
# @lc code=end

