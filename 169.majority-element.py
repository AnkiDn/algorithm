#
# @lc app=leetcode id=169 lang=python3
#
# [169] Majority Element
#
# https://leetcode.com/problems/majority-element/description/
#
# algorithms
# Easy (56.40%)
# Likes:    2740
# Dislikes: 211
# Total Accepted:    545.5K
# Total Submissions: 964.9K
# Testcase Example:  '[3,2,3]'
#
# Given an array of size n, find the majority element. The majority element is
# the element that appears more than ⌊ n/2 ⌋ times.
# 
# You may assume that the array is non-empty and the majority element always
# exist in the array.
# 
# Example 1:
# 
# 
# Input: [3,2,3]
# Output: 3
# 
# Example 2:
# 
# 
# Input: [2,2,1,1,1,2,2]
# Output: 2
# 
# 
#

# @lc code=start
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        nums.sort()
        return nums[len(nums) >> 1]

    def majorityElement(self, nums: List[int]) -> int:
        currentNum = nums[0]
        currentCount = 1
        for i in range(1, len(nums)):
            if not currentCount:
                currentNum = nums[i]
                currentCount = 1
            else:
                if currentNum == nums[i]:
                    currentCount += 1
                else:
                    currentCount -= 1
        return currentNum
        
# @lc code=end

