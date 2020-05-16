#
# @lc app=leetcode id=25 lang=python3
#
# [25] Reverse Nodes in k-Group
#
# https://leetcode.com/problems/reverse-nodes-in-k-group/description/
#
# algorithms
# Hard (40.32%)
# Likes:    1943
# Dislikes: 350
# Total Accepted:    253.4K
# Total Submissions: 622.6K
# Testcase Example:  '[1,2,3,4,5]\n2'
#
# Given a linked list, reverse the nodes of a linked list k at a time and
# return its modified list.
# 
# k is a positive integer and is less than or equal to the length of the linked
# list. If the number of nodes is not a multiple of k then left-out nodes in
# the end should remain as it is.
# 
# 
# 
# 
# Example:
# 
# Given this linked list: 1->2->3->4->5
# 
# For k = 2, you should return: 2->1->4->3->5
# 
# For k = 3, you should return: 3->2->1->4->5
# 
# Note:
# 
# 
# Only constant extra memory is allowed.
# You may not alter the values in the list's nodes, only nodes itself may be
# changed.
# 
# 
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        def can_reverse(node, k):
            while k:
                if not node: return False
                node = node.next
                k -= 1
            return True

        def reverse(node, k):
            pre, cur = None, node
            while k:
                nxt = cur.next
                cur.next = pre
                pre = cur
                cur = nxt
                k -= 1
            return pre, cur

        def dfs(node, k):
            if not can_reverse(node, k): return node
            pre, cur = reverse(node, k)
            node.next = dfs(cur, k)
            return pre
        return dfs(head, k)
        
# @lc code=end

