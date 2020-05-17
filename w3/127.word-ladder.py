#
# @lc app=leetcode id=127 lang=python3
#
# [127] Word Ladder
#
# https://leetcode.com/problems/word-ladder/description/
#
# algorithms
# Medium (28.20%)
# Likes:    2735
# Dislikes: 1081
# Total Accepted:    391.9K
# Total Submissions: 1.4M
# Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
#
# Given two words (beginWord and endWord), and a dictionary's word list, find
# the length of shortest transformation sequence from beginWord to endWord,
# such that:
# 
# 
# Only one letter can be changed at a time.
# Each transformed word must exist in the word list.
# 
# 
# Note:
# 
# 
# Return 0 if there is no such transformation sequence.
# All words have the same length.
# All words contain only lowercase alphabetic characters.
# You may assume no duplicates in the word list.
# You may assume beginWord and endWord are non-empty and are not the same.
# 
# 
# Example 1:
# 
# 
# Input:
# beginWord = "hit",
# endWord = "cog",
# wordList = ["hot","dot","dog","lot","log","cog"]
# 
# Output: 5
# 
# Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
# "dog" -> "cog",
# return its length 5.
# 
# 
# Example 2:
# 
# 
# Input:
# beginWord = "hit"
# endWord = "cog"
# wordList = ["hot","dot","dog","lot","log"]
# 
# Output: 0
# 
# Explanation: The endWord "cog" is not in wordList, therefore no possible
# transformation.
# 
# 
# 
# 
# 
#

# @lc code=start
class Solution:
    # 单队列超时
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        ans = 0
        queue = []
        queue.append(beginWord)
        visited = []
        visited.append(beginWord)
        while queue:
            size = len(queue)
            ans += 1
            for i in range(size):
                start = queue.pop(0)
                if start == endWord:
                    return ans
                for s in wordList:
                    if s in visited: continue
                    dif = 0
                    for char in range(len(start)):
                        if start[char] != s[char]:
                            dif += 1
                        if dif > 1:
                            continue
                    if dif == 1:
                        queue.append(s)
                        visited.append(s)
        return 0

    # 双队列
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        ans = 0
        if endWord not in wordList: return ans
        queue = []
        queue.append(beginWord)
        visited = []
        visited.append(beginWord)
        queue2 = []
        queue2.append(endWord)
        visited2 = []
        visited2.append(endWord)
        while queue and queue2:
            if len(queue) > len(queue2):
                temp_q = queue
                queue = queue2
                queue2 = temp_q
                temp_v = visited
                visited = visited2
                visited2 = temp_v
            size = len(queue)
            ans += 1
            for i in range(size):
                start = queue.pop(0)
                for s in wordList:
                    if s in visited: continue
                    if not self.valid_change(start, s): continue
                    if s in visited2:
                        return ans + 1
                    queue.append(s)
                    visited.append(s)
        return 0

    def valid_change(self, start, target):
        dif = 0
        for char in range(len(start)):
            if start[char] != target[char]:
                dif += 1
            if dif > 1:
                return False
        if dif == 1: return True
        
# @lc code=end

