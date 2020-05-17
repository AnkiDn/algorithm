#
# @lc app=leetcode id=17 lang=python3
#
# [17] Letter Combinations of a Phone Number
#
# https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
#
# algorithms
# Medium (45.45%)
# Likes:    3504
# Dislikes: 385
# Total Accepted:    567.5K
# Total Submissions: 1.2M
# Testcase Example:  '"23"'
#
# Given a string containing digits from 2-9 inclusive, return all possible
# letter combinations that the number could represent.
# 
# A mapping of digit to letters (just like on the telephone buttons) is given
# below. Note that 1 does not map to any letters.
# 
# 
# 
# Example:
# 
# 
# Input: "23"
# Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
# 
# 
# Note:
# 
# Although the above answer is in lexicographical order, your answer could be
# in any order you want.
# 
#

# @lc code=start
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        dic = {'2':'abc', '3':'def', '4':'ghi', '5':'jkl', '6':'mno', '7':'pqrs', '8':'tuv', '9':'wxyz'}
        ans = []
        if not digits: return ans
        self.dfs(dic, ans, 0, digits, '')
        return ans

    def dfs(self, dic, ans, level, digits, temp):
        if level == len(digits):
            ans.append(''.join(temp))
            return
        for char in dic[digits[level]]:
            a = temp
            temp += char
            self.dfs(dic, ans, level + 1, digits, temp)
            temp = a
        
# @lc code=end

