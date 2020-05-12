#
# @lc app=leetcode id=84 lang=python3
#
# [84] Largest Rectangle in Histogram
#
# https://leetcode.com/problems/largest-rectangle-in-histogram/description/
#
# algorithms
# Hard (33.88%)
# Likes:    3093
# Dislikes: 77
# Total Accepted:    237.2K
# Total Submissions: 699.9K
# Testcase Example:  '[2,1,5,6,2,3]'
#
# Given n non-negative integers representing the histogram's bar height where
# the width of each bar is 1, find the area of largest rectangle in the
# histogram.
# 
# 
# 
# 
# Above is a histogram where width of each bar is 1, given height =
# [2,1,5,6,2,3].
# 
# 
# 
# 
# The largest rectangle is shown in the shaded area, which has area = 10
# unit.
# 
# 
# 
# Example:
# 
# 
# Input: [2,1,5,6,2,3]
# Output: 10
# 
# 
#

# @lc code=start
class Solution:
    # python超时
    def largestRectangleArea(self, heights: List[int]) -> int:
        ans = 0
        for i in range(len(heights)):
            left, right = i, i
            while left > 0:
                left -= 1
                if heights[left] < heights[i]:
                    left += 1
                    break
            while right < len(heights) - 1:
                right += 1
                if heights[right] < heights[i]:
                    right -= 1
                    break
            ans = max(ans, heights[i] * (right - left + 1))
        return ans
            
        
# @lc code=end

