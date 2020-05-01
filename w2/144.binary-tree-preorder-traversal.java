import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (54.46%)
 * Likes:    1296
 * Dislikes: 54
 * Total Accepted:    460.4K
 * Total Submissions: 844.2K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,2,3]
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recur(root, list);
        return list;
    }

    private void recur (TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.left != null) {
            recur(node.left, list);
        }
        if (node.right != null) {
            recur(node.right, list);
        }
    }

    /**
     * 同中序遍历第二种解法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<StatusNode> stack = new Stack<>();
        stack.push(new StatusNode(StatusNode.WITHE, root));
        while (!stack.isEmpty()) {
            StatusNode statusNode = stack.pop();
            if (statusNode.node == null) continue;
            switch (statusNode.color) {
                case StatusNode.WITHE:
                    stack.push(new StatusNode(StatusNode.WITHE, statusNode.node.right));
                    stack.push(new StatusNode(StatusNode.WITHE, statusNode.node.left));
                    stack.push(new StatusNode(StatusNode.GRAY, statusNode.node));
                    break;
                default:
                    list.add(statusNode.node.val);
                    break;
            }
        }
        return list;
    }

    /**
     * 第二种简化版
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                result.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return result;
    }
}

class StatusNode {
    final static int WITHE = 0, GRAY = 1;
    int color;
    TreeNode node;
    StatusNode(int color, TreeNode node) {
        this.color = color;
        this.node = node;
    }
}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
// @lc code=end

