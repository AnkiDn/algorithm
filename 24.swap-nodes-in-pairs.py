#
# @lc app=leetcode id=24 lang=python3
#
# [24] Swap Nodes in Pairs
#
# https://leetcode.com/problems/swap-nodes-in-pairs/description/
#
# algorithms
# Medium (48.98%)
# Likes:    2012
# Dislikes: 160
# Total Accepted:    443K
# Total Submissions: 899.9K
# Testcase Example:  '[1,2,3,4]'
#
# Given a linked list, swap every two adjacent nodes and return its head.
# 
# You may not modify the values in the list's nodes, only nodes itself may be
# changed.
# 
# 
# 
# Example:
# 
# 
# Given 1->2->3->4, you should return the list as 2->1->4->3.
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

    # 定义一个快慢指针的递归方法
    def swapPairs(self, head: ListNode) -> ListNode:
        if head is None: return head
        return self.swap(head, head.next)

    def swap(self, head, fast):
        if head is None or fast is None: return head
        temp = fast.next
        fast.next = head
        if temp is None:
            head.next = None
        else:
            head.next = self.swap(temp, temp.next)
        return fast

    def swapPairs(self, head: ListNode) -> ListNode:
        if head is None or head.next is None: return head
        fast = head.next
        head.next = self.swapPairs(fast.next)
        fast.next = head
        return fast
        
        
# @lc code=end

