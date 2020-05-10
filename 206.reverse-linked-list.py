#
# @lc app=leetcode id=206 lang=python3
#
# [206] Reverse Linked List
#
# https://leetcode.com/problems/reverse-linked-list/description/
#
# algorithms
# Easy (60.59%)
# Likes:    4008
# Dislikes: 84
# Total Accepted:    918.7K
# Total Submissions: 1.5M
# Testcase Example:  '[1,2,3,4,5]'
#
# Reverse a singly linked list.
# 
# Example:
# 
# 
# Input: 1->2->3->4->5->NULL
# Output: 5->4->3->2->1->NULL
# 
# 
# Follow up:
# 
# A linked list can be reversed either iteratively or recursively. Could you
# implement both?
# 
#

# @lc code=start
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        cur = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return cur

    def reverseList(self, head: ListNode) -> ListNode:
        if head is None:
            return
        pre = None
        cur = head
        while cur:
            temp = cur.next
            cur.next = pre
            pre = cur
            cur = temp
        return pre

# @lc code=end
