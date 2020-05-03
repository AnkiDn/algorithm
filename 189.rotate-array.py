#
# @lc app=leetcode id=189 lang=python3
#
# [189] Rotate Array
#
# https://leetcode.com/problems/rotate-array/description/
#
# algorithms
# Easy (33.55%)
# Likes:    2388
# Dislikes: 766
# Total Accepted:    443.1K
# Total Submissions: 1.3M
# Testcase Example:  '[1,2,3,4,5,6,7]\n3'
#
# Given an array, rotate the array to the right by k steps, where k is
# non-negative.
# 
# Example 1:
# 
# 
# Input: [1,2,3,4,5,6,7] and k = 3
# Output: [5,6,7,1,2,3,4]
# Explanation:
# rotate 1 steps to the right: [7,1,2,3,4,5,6]
# rotate 2 steps to the right: [6,7,1,2,3,4,5]
# rotate 3 steps to the right: [5,6,7,1,2,3,4]
# 
# 
# Example 2:
# 
# 
# Input: [-1,-100,3,99] and k = 2
# Output: [3,99,-1,-100]
# Explanation: 
# rotate 1 steps to the right: [99,-1,-100,3]
# rotate 2 steps to the right: [3,99,-1,-100]
# 
# 
# Note:
# 
# 
# Try to come up as many solutions as you can, there are at least 3 different
# ways to solve this problem.
# Could you do it in-place with O(1) extra space?
# 
#

# @lc code=start
class Solution:
    def rotate(self, nums: List[int], k: int):
        k %= len(nums)
        if k == 0:
            return 
        def swap(nums, start, end):
            while start < end:
                nums[start], nums[end] = nums[end], nums[start]
                start += 1
                end -= 1
        swap(nums, 0, len(nums) - 1)
        swap(nums, 0, k - 1)
        swap(nums, k, len(nums) - 1)

    def rotate(self, nums: List[int], k: int) -> None:
        k %= len(nums)
        if k == 0:
            return
        nums = nums[-k:] + nums[:-k]

    
    def rotate(self, nums: List[int], k: int):
        k %= len(nums)
        count = 0;
        for i in range(len(nums)):
            if count == len(nums):
                return
            start = i
            startValue = nums[start]
            while True:
                next = (start + k) % len(nums)
                nums[next], startValue = startValue, nums[next]
                start = next
                count += 1
                if start == i:
                    break


# @lc code=end

