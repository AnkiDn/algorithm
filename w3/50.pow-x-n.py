#
# @lc app=leetcode id=50 lang=python3
#
# [50] Pow(x, n)
#
# https://leetcode.com/problems/powx-n/description/
#
# algorithms
# Medium (29.26%)
# Likes:    1296
# Dislikes: 2811
# Total Accepted:    436.3K
# Total Submissions: 1.5M
# Testcase Example:  '2.00000\n10'
#
# Implement pow(x, n), which calculates x raised to the power n (x^n).
# 
# Example 1:
# 
# 
# Input: 2.00000, 10
# Output: 1024.00000
# 
# 
# Example 2:
# 
# 
# Input: 2.10000, 3
# Output: 9.26100
# 
# 
# Example 3:
# 
# 
# Input: 2.00000, -2
# Output: 0.25000
# Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
# 
# 
# Note:
# 
# 
# -100.0 < x < 100.0
# n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
# 
# 
#

# @lc code=start
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if x == 0: return 0
        ans = 1
        if n < 0:
            x = 1 / x
            n = -n
        ans = self.fastPow(x, n)
        return ans

    def fastPow(self, x, n):
        if n == 0: return 1
        half = self.fastPow(x, n >> 1)
        if n & 1:
            return half * half * x
        else:
            return half * half
    
    def myPow(self, x: float, n: int) -> float:
        if x == 0: return 0
        if n < 0:
            x = 1 / x
            n = -n
        ans = 1
        while n:
            if n & 1:
                ans *= x
            x = x * x
            n >>= 1
        return ans
    
# @lc code=end

