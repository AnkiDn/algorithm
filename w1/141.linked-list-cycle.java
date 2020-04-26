import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start

//   Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle1(ListNode head) {
        if (head == null) return false;
        Set<ListNode> set = new HashSet<>();
        while(head.next != null) {
            head = head.next;
            if(set.contains(head)){
                return true;
            } else {
                set.add(head);
            }
        }
        return false;
    }

    /**
     * 快慢指针,小心只有一个元素自身成环
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode quick = head.next;
        while(slow != quick) {
            if (quick == null || quick.next == null) return false;
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }
}
// @lc code=end
