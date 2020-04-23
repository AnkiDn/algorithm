import java.util.LinkedList;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack1 {

    LinkedList<Integer> stack = null;
    LinkedList<Integer> minStack = null;
    
    /** initialize your data structure here. 
     * 双链表
    */
    public MinStack1() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.add(x);
        if (minStack.isEmpty()) {
            minStack.add(x);
        } else if (x > minStack.element()) {
            minStack.addLast(x);
        } else {
            minStack.addFirst(x);
        }
    }

    public void pop() {
        minStack.remove(stack.pollLast());
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return minStack.element();
    }
}

class MinStack2 {

    private Node head;
    /** initialize your data structure here. 
     * 自实现链表
    */
    public MinStack2() {
        
    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    class Node {
        int val;
        int min;
        Node next;
        
        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
// @lc code=end
