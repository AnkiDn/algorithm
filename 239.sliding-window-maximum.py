#
# @lc app=leetcode id=239 lang=python3
#
# [239] Sliding Window Maximum
#
# https://leetcode.com/problems/sliding-window-maximum/description/
#
# algorithms
# Hard (41.56%)
# Likes:    2868
# Dislikes: 164
# Total Accepted:    241.7K
# Total Submissions: 581K
# Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
#
# Given an array nums, there is a sliding window of size k which is moving from
# the very left of the array to the very right. You can only see the k numbers
# in the window. Each time the sliding window moves right by one position.
# Return the max sliding window.
# 
# Follow up:
# Could you solve it in linear time?
# 
# Example:
# 
# 
# Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
# Output: [3,3,5,5,6,7] 
# Explanation: 
# 
# Window position                Max
# ---------------               -----
# [1  3  -1] -3  5  3  6  7       3
# ⁠1 [3  -1  -3] 5  3  6  7       3
# ⁠1  3 [-1  -3  5] 3  6  7       5
# ⁠1  3  -1 [-3  5  3] 6  7       5
# ⁠1  3  -1  -3 [5  3  6] 7       6
# ⁠1  3  -1  -3  5 [3  6  7]      7
# 
# 
# 
# Constraints:
# 
# 
# 1 <= nums.length <= 10^5
# -10^4 <= nums[i] <= 10^4
# 1 <= k <= nums.length
# 
# 
#

# @lc code=start
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        deque = []
        def push(n):
            while deque and deque[-1] < n: #删除前n 个比填入数字小的数组 当前只保存最大的值
                deque.pop()
            deque.append(n)
        
        def max():
            return deque[0]

        def remove(n):
            if deque and deque[0] == n: 
                deque.pop(0)

        ans = []
        if not nums or not k:
            return ans
        for i, value in enumerate(nums):
            if i < k - 1: #这个地方先填充k-1个元素
                push(value)
            else:
                push(value) #填充第三个元素时 开始比较
                ans.append(max())
                remove(nums[i - k + 1])
        return ans
        
# @lc code=end

