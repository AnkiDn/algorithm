/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode prehead = new ListNode(0);
        ListNode temp = prehead;
        while(l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                temp.next = l2;
                l2 = l2.next;
            } else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
}
/**
 * 其实递归就是程序内部维护了一个栈。这个题就是每次都把最小值压入栈，
 * 最后出栈的时候，将所有数连在一起就可以了。说白了，就是用一个栈维护了顺序。
 * 最后的连接，当然是小的连小的，所以l1 小，就连到 l1,l2 小就连到 l2，
 * 最后先返回的，就是最小的头结点。
 */
public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
		if (l2 == null) return l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
}

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
// @lc code=end

