#
# @lc app=leetcode id=49 lang=python3
#
# [49] Group Anagrams
#
# https://leetcode.com/problems/group-anagrams/description/
#
# algorithms
# Medium (55.13%)
# Likes:    3133
# Dislikes: 166
# Total Accepted:    629.4K
# Total Submissions: 1.1M
# Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
#
# Given an array of strings, group anagrams together.
# 
# Example:
# 
# 
# Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
# Output:
# [
# ⁠ ["ate","eat","tea"],
# ⁠ ["nat","tan"],
# ⁠ ["bat"]
# ]
# 
# Note:
# 
# 
# All inputs will be in lowercase.
# The order of your output does not matter.
# 
# 
#

# @lc code=start
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dict = {}
        for value in strs:
            temp = str(sorted(value))
            if temp in dict:
                dict.get(temp).append(value)
            else:
                dict[temp] = [value]
        return list(dict.values())
        
# @lc code=end

